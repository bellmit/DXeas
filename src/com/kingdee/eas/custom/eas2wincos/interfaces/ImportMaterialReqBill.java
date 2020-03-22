package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.service.OrgCommonUtils;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.im.inv.IMaterialReqBill;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 领料出库单
 * @author lenovo
 */
public class ImportMaterialReqBill  implements IImport2EAS {
	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPProdReportConsumption";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "ERPProdReportConsumption";
	}
	@Override
	public String importBill(Context ctx,String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			companyID=EASWUtils.getCompanyIDByNumber(ctx, companyID);
			conn=EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			
			Date nowDate=new java.util.Date();
			Date nextDate = EASWUtils.getNextDay(nowDate);
			
			PreparedStatement ptm = conn.prepareStatement(getQueryStr());
			ptm.setDate(1, new java.sql.Date(nowDate.getTime()));
			ptm.setDate(2, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = ptm.executeQuery();
			
			ArrayList<Integer> winCosBillIDList=new ArrayList<Integer>();//保存wincos oid
			MaterialReqBillInfo info=null;
			String billNum=null,billNumKeep=null;
			int winCosBillID=0;
			rs.last();
			int count=rs.getRow();//最大行数
			rs.beforeFirst();
			while(rs.next()) {
				winCosBillID=rs.getInt("OID");
				billNum=rs.getString("ProcessOrderIdent");
				if(rs.getRow()==1) {
					billNumKeep=billNum;
				}
				if(rs.getRow()<count&&!billNumKeep.equals(billNum)) {
					exeImportSave(ctx,conn, info, winCosBillIDList);
					winCosBillIDList.clear();
					billNumKeep=billNum;
					info=null;
				}
				winCosBillIDList.add(winCosBillID);
				exeImportAction(ctx,companyID,info,rs);//执行插入
				if(rs.getRow()==count) {
					exeImportSave(ctx,conn, info, winCosBillIDList);
					winCosBillIDList.clear();
					billNumKeep=billNum;
					info=null;
				}
			}
			rs.close();
		}catch(Exception e) {
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

	/**
	 * 执行插入
	 * @param info
	 * @param rs
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws SQLException 
	 */
	private void exeImportAction(Context ctx,String companyID,MaterialReqBillInfo info,ResultSet rs) throws EASBizException, BOSException, SQLException {
		if(info==null) {
			info=new MaterialReqBillInfo();
			info.setBizDate(new java.util.Date());
			info.setBizType(BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("业务类型")));//业务类型
			info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("事务类型")));//事务类型
			info.setSupplyStoreOrgUnit(StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(companyID)));//供方库存组织
			info.setSupplyCompanyOrgUnit(CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)));//供方财务组织
			info.setSupplier(null);
			
			info.setStorageOrgUnit(StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(companyID)));
			info.setDemandCompanyOrgUnit(CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)));//需方财务组织
			info.setCU((CtrlUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, companyID, OrgType.ControlUnit, null));
		}
		MaterialReqBillEntryInfo entryInfo=new MaterialReqBillEntryInfo();
		String materialNum;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);		
		MaterialCollection mColl;
		MaterialInfo mInfo;
		EntityViewInfo ev;
		FilterInfo filter;
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
		entryInfo.setOrderBillId(null);//生产订单id
		entryInfo.setCostCenterOrgUnit((CostCenterOrgUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, companyID, OrgType.ControlUnit, null));//成本中心
		entryInfo.setSupplyWarehouse(null);//供方仓库
		entryInfo.setWarehouse(null);//需方仓库
		entryInfo.setLot(rs.getString("LotIdent"));
		entryInfo.setQty(rs.getBigDecimal("WeightActualConsumed"));
		entryInfo.setBaseQty(entryInfo.getQty());
		info.getEntry().add(entryInfo);
	}
	/**
	 * 执行保存
	 * @param conn
	 * @param info
	 * @param winCosBillNumList
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void exeImportSave(Context ctx,Connection conn,MaterialReqBillInfo info,ArrayList<Integer> winCosBillNumList) throws EASBizException, BOSException {
		if(info!=null) {
			IObjectPK pk = MaterialReqBillFactory.getLocalInstance(ctx).addnew(info);
			try {//反写出错则删除单据
				WinCosUtils.reWriteImportBillStatus(conn, getWinCosHeadTable(), pk.toString(), winCosBillNumList);//反写单据导入状态
			}catch(Exception e) {
				if(pk!=null) {
					MaterialReqBillFactory.getLocalInstance(ctx).delete(pk);
				}
			}
		}
	}
	
	@Override
	public String getQueryStr() {
		StringBuffer sql=new StringBuffer();
		sql.append(" select ");
		sql.append(" OID,ProdReport,");
		sql.append(" ProcessOrderIdent,JobIdent,ProductIdent,LotIdent,WeightActualConsumed,");
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
		sql.append(" order by ProcessOrderIdent asc");
		return sql.toString();
	}

	@Override
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate)
			throws EASBizException {
		Connection conn = null;
		try {
			companyID=EASWUtils.getCompanyIDByNumber(ctx, companyID);
			conn=EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			
			Date nowDate=new java.util.Date();
			Date nextDate = EASWUtils.getNextDay(nowDate);
			
			PreparedStatement ptm = conn.prepareStatement(getQueryStr());
			ptm.setDate(1, new java.sql.Date(nowDate.getTime()));
			ptm.setDate(2, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = ptm.executeQuery();
			ArrayList<Integer> winCosBillIDList=new ArrayList<Integer>();
			HashSet<String> sourceBillIDs=new HashSet<String>();//取关联wincos 的生产订单的EAS ID
			HashMap<String,BigDecimal> qtyMap=new HashMap<String,BigDecimal>();//数量 金额
			String billNum=null,billNumKeep=null;//wincos单据编码
			String materialNum;//物料编码
			BigDecimal qty=BigDecimal.ZERO;//同一物料的累计数量
			rs.last();
			int count=rs.getRow();
			rs.beforeFirst();
			while(rs.next()) {
				billNum=rs.getString("ProcessOrderIdent");
				if(rs.getRow()==1) {
					billNumKeep=billNum;
				}
				if(rs.getRow()<count&&!billNumKeep.equals(billNum)) {
					System.out.println("different number");
					exeImportByBotp(ctx, conn,sourceBillIDs, qtyMap,winCosBillIDList);
					winCosBillIDList.clear();
					sourceBillIDs.clear();
					qtyMap.clear();
				}
				winCosBillIDList.add(rs.getInt("OID"));
				sourceBillIDs.add(getSourceBillID(conn, rs.getInt("ProdReport")));//根据生产订单 添加来源单据id
				materialNum=rs.getString("ProductIdent");
				qty=rs.getBigDecimal("WeightActualConsumed");
				if(qty==null)
					qty=BigDecimal.ZERO;
				if(!qtyMap.containsKey(materialNum)) {
					qtyMap.put(materialNum,qty );
				}else {
					qty=qty.add(qtyMap.get(materialNum));
					qtyMap.put(materialNum,qty );
				}
				if(rs.getRow()==count) {
					billNumKeep=billNum;
					exeImportByBotp(ctx, conn,sourceBillIDs, qtyMap,winCosBillIDList);
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
	/**
	 * 执行单据转换
	 * @param ctx
	 * @throws ClassNotFoundException 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void exeImportByBotp(Context ctx,Connection conn,HashSet<String> sourceBillIDs,HashMap<String,BigDecimal> qtyMap,ArrayList<Integer> winCosBillNumList) throws BOSException, ClassNotFoundException, EASBizException {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("id",sourceBillIDs,CompareType.INCLUDE));
		ev.setFilter(filter);
		CoreBillBaseCollection col =EASWUtils.getIInstance(getEASSourceBosType()).getCoreBillBaseCollection();
		String id=EASWUtils.createToDestBill(ctx, col, getEASBosType());
		if(StringUtils.isBlank(id)) {
			return ;
		}
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add(new SelectorItemInfo("*"));
		slor.add(new SelectorItemInfo("entry.material.*"));
		IMaterialReqBill ims = MaterialReqBillFactory.getLocalInstance(ctx);
		MaterialReqBillInfo info=ims.getMaterialReqBillInfo(new ObjectUuidPK(id),slor);
		MaterialReqBillEntryInfo entryInfo;
		for(int index=0;index<info.getEntry().size();index++) {
			entryInfo=info.getEntry().get(index);
			entryInfo.setQty(qtyMap.get(entryInfo.getMaterial().getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
		}
		IObjectPK pk=null;
		try{
			 pk= ims.submit(info);
			//ims.audit(new ObjectUuidPK(id));
			WinCosUtils.reWriteImportBillStatus(conn, getWinCosHeadTable(), pk.toString(), winCosBillNumList);//反写单据导入状态
		}catch(Exception e1){
			if(pk!=null) {
				MaterialReqBillFactory.getLocalInstance(ctx).delete(pk);
			}
		}
	}
	/**
	 * 得到来源 EAS 单据id
	 */
	@Override
	public String getSourceBillID(Connection conn,int wincosSourceBillID) {
		// TODO Auto-generated method stub
		String result=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" select AppString02");
		sql.append(" from ").append(getWinCosSourceTable());
		sql.append(" where OID=").append(wincosSourceBillID);
		try{
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if(rs.next()) {
				result=rs.getString("AppString02");
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
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
		return "1D0D80DD";
	}

	@Override
	public String getEASBosType() {
		// TODO Auto-generated method stub
		return "500AB75E";
	}

	
}
