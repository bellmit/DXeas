package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.math.BigDecimal;
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
import com.kingdee.eas.mm.basedata.BomCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.util.NumericExceptionSubItem;

public class ExportBOM implements IExport2WinCos {

	@Override
	public String export2WinCos(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils.getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			IBom ips = BomFactory.getLocalInstance(ctx);
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if(StringUtils.isBlank(beginDate)&&StringUtils.isBlank(endDate)) {//如果开始日期和结束日期都为空  ，则为服务器端调用，默认为当前业务日期
				filter.getFilterItems().add(new FilterItemInfo("auditTime", new java.util.Date(), CompareType.EQUALS));
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(new FilterItemInfo("auditTime", format.parse(beginDate+" 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("auditTime", format.parse(endDate+" 23:59:59"), CompareType.LESS_EQUALS));
			}
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			 BomCollection coll = ips.getBomCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}
			//执行插入的预编译方法
			PreparedStatement ptm=null;
			int billHeadID=0;
			BomInfo	bomInfo;
			BomEntryInfo bomEntryInfo;
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("material.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			for (int index = 0; index < coll.size(); index++) {
				bomInfo = ips.getBomInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
				
//				if (EASWUtils.checkHasExported(conn, getWinCosHeadTable(), bomInfo.getId().toString(),null)>0) {
//					continue;
//				}
				
				ptm = conn.prepareStatement(getInsertHeadSql());//插入表头
				
				ptm.setString(1, bomInfo.getNumber());
				ptm.setString(2,"");//批次号
				ptm.setInt(3, 0);//物料类型
				ptm.setString(4, bomInfo.getMaterial().getNumber());//物料 编码
				ptm.setString(5, bomInfo.getMaterial().getName());
				ptm.setString(6, bomInfo.getDescription());
				ptm.setBigDecimal(7, bomInfo.getProductQty());//仓库
				ptm.setBigDecimal(8, bomInfo.getProductBaseQty());
				ptm.setBigDecimal(9, BigDecimal.ZERO);
				ptm.setBigDecimal(10, BigDecimal.ZERO);//保质期
				ptm.setString(11,bomInfo.getId().toString());
				ptm.setDate(12, new java.sql.Date(new java.util.Date().getTime()));
				ptm.execute();
//				billHeadID=EASWUtils.checkHasExported(conn, getWinCosHeadTable(), bomInfo.getId().toString(),null);//查询单据头id
				ptm = conn.prepareStatement(getInsertEntrySql());//插入表体
				// 已经导入不再重新导入
				for(int j=0;j<bomInfo.getEntrys().size();j++) {
					bomEntryInfo=bomInfo.getEntrys().get(j);
					/*if (checkHasExported(conn, WinCos_SaleIssueEntry_TableName, saleIssueInfo.getId().toString(),saleIssueEntryInfo.getId().toString())) {
						continue;
					}*/
					/*if (checkHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(),purEntryInfo.getId().toString())) {
						continue;
					}*/
					ptm.setInt(1, billHeadID);//单据头id
					ptm.setString(2, bomEntryInfo.getMaterial().getNumber());//
					ptm.setString(3, bomEntryInfo.getMaterial().getName());//
					ptm.setString(4, bomEntryInfo.getRemark());//
					ptm.setInt(5, bomEntryInfo.getOperationNo());//
					ptm.setBoolean(6,false);//是否载体
					ptm.setBigDecimal(7, bomEntryInfo.getProportion());//消耗百分比
					ptm.setBigDecimal(8, bomEntryInfo.getConsumeFixQty());//消耗重量
					ptm.setString(9,bomInfo.getId().toString()); 
					ptm.setString(10, bomEntryInfo.getId().toString());
					ptm.setDate(11, new java.sql.Date(new java.util.Date().getTime()));
					ptm.execute();
					//在eas中插入导出记录
					//insertHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(), purEntryInfo.getId().toString());
				}
				conn.commit();
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
				try {
					if(conn!=null&&!conn.isClosed()) {
						conn.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
		sql.append(" Order,ProductIdent,ProductName,Description,Position,");
		sql.append(" IsCarrier,Percentage,WeightTarget,CreationDate,AppString02,");
		sql.append(" AppString03");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getInsertHeadSql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosHeadTable()).append(" ( ");
		sql.append(" Ident,BatchIdent,ProductType,ProductIdent,ProductName,");
		sql.append(" Description,WeightTarget,BlendPackSize,InnERPackSize,ProductBestBeforeLifetime,");
		sql.append(" MixingTime,PreMixingTime,MaxBatchWeight,CanBeUsedForRemix,ButtsAdditionAllowed,");
		sql.append(" ApplyPlantProductionOverage,SubstitutionsAllowed,AppString02,CreationDate");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" 0,0,0,0,0,");
		sql.append(" 0,0,0,?,?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPOrderIngredient";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "ERPProcessOrderHead";
	}
	@Override
	public String getBosType() {
		return null;
	}

	@Override
	public String export2WinCosByID(Context ctx, String companyNum, String billID) throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}


}
