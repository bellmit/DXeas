package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.service.OrgCommonUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillEntryInfo;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillFactory;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 生产入库单
 * @author lenovo
 *
 */
public class ImportProductIn implements IImport2EAS{

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPProdReportFinished";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "ERPProdReportFinished";
	}

	@Override
	public String importBill(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			companyID=EASWUtils.getCompanyIDByNumber(ctx, companyID);
			conn= EASWUtils.getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			
			Date nowDate=new java.util.Date();
			Date nextDate = EASWUtils.getNextDay(nowDate);
			
			PreparedStatement ptm = conn.prepareStatement(getQueryStr());
			ptm.setDate(1, new java.sql.Date(nowDate.getTime()));
			ptm.setDate(2, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = ptm.executeQuery();
			
			ArrayList<Integer> winCosBillNumList=new ArrayList<Integer>();
			ManufactureRecBillInfo info=null;
			String materialNum;
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);		
			MaterialCollection mColl;
			MaterialInfo mInfo;
			EntityViewInfo ev;
			FilterInfo filter;
			while(rs.next()) {
				winCosBillNumList.add(rs.getInt("OID"));
				if(info==null) {
					info=new ManufactureRecBillInfo();
					info.setBizDate(new java.util.Date());
					info.setCU((CtrlUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, companyID, OrgType.ControlUnit, null));
				}
				ManufactureRecBillEntryInfo entryInfo=new ManufactureRecBillEntryInfo();
				materialNum=rs.getString("ProductIdent");
				ev=new EntityViewInfo();
				filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("number",materialNum,CompareType.EQUALS));
				ev.setFilter(filter);
				mColl=ims.getMaterialCollection(ev);//根据物料编码获取物料
				if(mColl!=null&&mColl.size()>0) {
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(mColl.get(0).getString("id")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setBaseUnit(mInfo.getBaseUnit());
				}
				entryInfo.setLot(rs.getString("LotIdent"));
				entryInfo.setQty(rs.getBigDecimal("WeightActualConsumed"));
				entryInfo.setWarehouse(null);//仓库 
				info.getEntry().add(entryInfo);
			}
			rs.close();
			if(info!=null) {
				IObjectPK pk = ManufactureRecBillFactory.getLocalInstance(ctx).addnew(info);
				try {//反写出错则删除单据
					WinCosUtils. reWriteImportBillStatus(conn, getWinCosHeadTable(), pk.toString(), winCosBillNumList);//反写单据导入状态
				}catch(Exception e) {
					if(pk!=null) {
						ManufactureRecBillFactory.getLocalInstance(ctx).delete(pk);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally {
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
	public String getQueryStr() {
		StringBuffer sql=new StringBuffer();
		sql.append(" select ");
		sql.append(" OID,ProdReport,");
		sql.append(" ProcessOrde-rIdent,JobIdent,ProductIdent,LotIdent,WeightActu-alConsumed,");
		sql.append(" LocationID");
		sql.append(" from").append(getWinCosHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and CreationDate>=?");
		sql.append(" and CreationDate<=?");
		sql.append(" and ( AppString03 is  null or AppString03='')");
		/*sql.append(" and ProcessOrde-rIdent not in(");//在中间库新增导入记录表
		sql.append(" select distinct FWinCosBillNum from ").append(WinCos_EASRecord_tableName);
		sql.append(" where FWinCosBillType=1");
		sql.append(" )");*/
		sql.append(" order by ProcessOrde-rIdent asc");
		return sql.toString();
	}

	@Override
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate)
			throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSourceBillID(Connection conn,int wincosSourceBillID) {
		// TODO Auto-generated method stub
		String result=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" select ");
		sql.append(" from ").append(getWinCosSourceTable());
		sql.append(" where OID=").append(wincosSourceBillID);
		try{
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql.toString());
		if(rs.next()) {
			result=rs.getString("");
		}
		}catch(Exception e){e.printStackTrace();}
		return result; 
	}

	@Override
	public String getWinCosSourceTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEASSourceBosType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEASBosType() {
		// TODO Auto-generated method stub
		return null;
	}

}
