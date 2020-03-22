package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.IMoveInWarehsBill;
import com.kingdee.eas.scm.im.inv.MoveInWarehsBillCollection;
import com.kingdee.eas.scm.im.inv.MoveInWarehsBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MoveInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.MoveInWarehsBillInfo;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 导出调拨入库单
 * @author lenovo
 *
 */
public class ExportMoveIn implements IExport2WinCos{
	public String export2WinCos(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			IMoveInWarehsBill ips = MoveInWarehsBillFactory.getLocalInstance(ctx);
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", companyID, CompareType.EQUALS));//库存组织
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if(StringUtils.isBlank(beginDate)&&StringUtils.isBlank(endDate)) {//如果开始日期和结束日期都为空  ，则为服务器端调用，默认为当前业务日期
				filter.getFilterItems().add(new FilterItemInfo("bizDate", new java.util.Date(), CompareType.EQUALS));
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(new FilterItemInfo("bizDate", format.parse(beginDate+" 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("bizDate", format.parse(endDate+" 23:59:59"), CompareType.LESS_EQUALS));
			}
			//filter.getFilterItems().add(new FilterItemInfo("id",EASWUtils.getHasExportedIDs(ctx,"783061E3"),CompareType.NOTINCLUDE));//不包含已经导入的
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("number"));
			ev.setSorter(sorter);
			MoveInWarehsBillCollection coll = ips.getMoveInWarehsBillCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}
			//执行插入的预编译方法
			PreparedStatement ptm = conn.prepareStatement(getInsertEntrySql());
			MoveInWarehsBillInfo moveInfo;
			MoveInWarehsBillEntryInfo moveEntryInfo;
			
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("supplier.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			Boolean isSuccess=false;
			String msg=null;
			String billID=null;
			for (int index = 0; index < coll.size(); index++) {
				try{
					moveInfo = ips.getMoveInWarehsBillInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
					isSuccess=true;
					msg=null;
					billID=moveInfo.getString("id");
					// 已经导入不再重新导入
					for(int j=0;j<moveInfo.getEntry().size();j++) {
						moveEntryInfo=moveInfo.getEntry().get(j);
						if (WinCosUtils.checkHasExported(conn, getWinCosEntryTable(), moveInfo.getId().toString(),moveEntryInfo.getId().toString())>0) {
							continue;
						}
						/*if (checkHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(),purEntryInfo.getId().toString())) {
							continue;
						}*/
						ptm.setString(1, moveEntryInfo.getMaterial().getNumber());
						ptm.setString(2, moveEntryInfo.getMaterial().getName());
						ptm.setString(3, moveEntryInfo.getLot()==null?"":moveEntryInfo.getLot());
						ptm.setDate(4, null);
						ptm.setInt(5, 0);
						ptm.setBigDecimal(6, moveEntryInfo.getQty());
						ptm.setBigDecimal(7, moveEntryInfo.getBaseQty());
						ptm.setString(8, "");
						ptm.setString(9, "");
						ptm.setInt(10, 0);
	//					ptm.setBoolean(11, false);
						ptm.setString(11,moveInfo.getId().toString()); 
						ptm.setString(12, moveEntryInfo.getId().toString());
						ptm.setTimestamp(13, new java.sql.Timestamp(new java.util.Date().getTime()));
						ptm.execute();
					}
					conn.commit();
					//EASWUtils.insertHasExported(ctx, getBosType(), purInfo.getString("id"), null);//插入导出记录 
				}catch(Exception ee) {
					isSuccess=false;
					msg=ee.getMessage();
					try {
						if(conn!=null&&!conn.isClosed()) {
							conn.rollback();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				finally{ 
					EASWUtils.insertLogs(ctx, getBosType(), billID, 0, EASWUtils.Direction_Export, isSuccess, msg);//插入日志
				}
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public String export2WinCosByID(Context ctx, String companyID, String billID) throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			IMoveInWarehsBill ips = MoveInWarehsBillFactory.getLocalInstance(ctx);
			//执行插入的预编译方法
			PreparedStatement ptm = conn.prepareStatement(getInsertEntrySql());
			MoveInWarehsBillInfo moveInfo;
			MoveInWarehsBillEntryInfo moveEntryInfo;
			
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("supplier.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			Boolean isSuccess=false;
			String msg=null;
			try{
				moveInfo = ips.getMoveInWarehsBillInfo(new ObjectUuidPK(billID),slor);
				isSuccess=true;
				msg=null;
				billID=moveInfo.getString("id");
				// 已经导入不再重新导入
				for(int j=0;j<moveInfo.getEntry().size();j++) {
					moveEntryInfo=moveInfo.getEntry().get(j);
					if (WinCosUtils.checkHasExported(conn, getWinCosEntryTable(), moveInfo.getId().toString(),moveEntryInfo.getId().toString())>0) {
						continue;
					}
					/*if (checkHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(),purEntryInfo.getId().toString())) {
						continue;
					}*/
					ptm.setString(1, moveEntryInfo.getMaterial().getNumber());
					ptm.setString(2, moveEntryInfo.getMaterial().getName());
					ptm.setString(3, moveEntryInfo.getLot()==null?"":moveEntryInfo.getLot());
					ptm.setDate(4, null);
					ptm.setInt(5, 0);
					ptm.setBigDecimal(6, moveEntryInfo.getQty());
					ptm.setBigDecimal(7, moveEntryInfo.getBaseQty());
					ptm.setString(8, "");
					ptm.setString(9, "");
					ptm.setInt(10, 0);
//					ptm.setBoolean(11, false);
					ptm.setString(11,moveInfo.getId().toString()); 
					ptm.setString(12, moveEntryInfo.getId().toString());
					ptm.setTimestamp(13, new java.sql.Timestamp(new java.util.Date().getTime()));
					ptm.execute();
				}
				conn.commit();
				//EASWUtils.insertHasExported(ctx, getBosType(), purInfo.getString("id"), null);//插入导出记录 
			}catch(Exception ee) {
				isSuccess=false;
				msg=ee.getMessage();
				try {
					if(conn!=null&&!conn.isClosed()) {
						conn.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{ 
				EASWUtils.insertLogs(ctx, getBosType(), billID, 0, EASWUtils.Direction_Export, isSuccess, msg);//插入日志
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public String getInsertEntrySql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosEntryTable()).append(" (");
		sql.append(" ProductIdent,ProductName,LotIdent,ProductBestBeforeDate,PackingType,");
		sql.append(" PackSize,WeightTarget,SupplierIdent,SupplierName,State,");
		sql.append(" AppString02,AppString03,Visible,CreationDate");
		sql.append(" )values( ");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,1,?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPRawMaterialReceival";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBosType() {
		return "E3DAFF63";
	}

}
