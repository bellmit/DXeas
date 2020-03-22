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
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.util.NumericExceptionSubItem;

public class ExportMaterial implements IExport2WinCos {

	@Override
	public String export2WinCos(Context ctx, String companyID, String beginDate, String endDate)
			throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			//filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", companyID, CompareType.EQUALS));//库存组织
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if(StringUtils.isBlank(beginDate)&&StringUtils.isBlank(endDate)) {//如果开始日期和结束日期都为空  ，则为服务器端调用，默认为当前业务日期
				filter.getFilterItems().add(new FilterItemInfo("createTime", new java.util.Date(), CompareType.EQUALS));
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(new FilterItemInfo("createTime", format.parse(beginDate+" 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("createTime", format.parse(endDate+" 23:59:59"), CompareType.LESS_EQUALS));
			}
			//filter.getFilterItems().add(new FilterItemInfo("id",EASWUtils.getHasExportedIDs(ctx,"783061E3"),CompareType.NOTINCLUDE));//不包含已经导入的
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("number"));
			ev.setSorter(sorter);
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);
			 MaterialCollection coll = ims.getMaterialCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}
			//执行插入的预编译方法
			PreparedStatement ptm = conn.prepareStatement(getInsertEntrySql());
			MaterialInfo mInfo;
			
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			Boolean isSuccess=false;
			String msg=null;
			String billID=null;
			for (int index = 0; index < coll.size(); index++) {
				try{
					mInfo = ims.getMaterialInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
					billID=mInfo.getString("id");
					isSuccess=true;
					msg=null;
				// 已经导入不再重新导入
					if (WinCosUtils.checkHasExported(conn, getWinCosEntryTable(), mInfo.getId().toString(),null)>0) {
						continue;
					}
					/*if (checkHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(),purEntryInfo.getId().toString())) {
						continue;
					}*/
					ptm.setString(1, "");
					ptm.execute();
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
	public String getBosType() {
		// TODO Auto-generated method stub
		return "4409E7F0";
	}

	@Override
	public String getInsertEntrySql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosHeadTable()).append(" (");
		sql.append(" ");
		sql.append(" ");
		sql.append(" ");
		return null;
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String export2WinCosByID(Context ctx, String companyNum, String billID) throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

}
