package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.IBillType;
import com.kingdee.eas.basedata.scm.common.ITransactionType;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
//import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.AppCommon;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.scm.common.PurchaseTypeEnum;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.common.SCMBillException;
import com.kingdee.eas.scm.im.inv.IMaterialReqBill;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 导入领料出库单
 * 
 * @author chuanyin
 * 
 */
public class ImportMaterialReqBill implements IImport2EAS {

	/**
	 * 通过botp导入领料出库单
	 */
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate,String TempClass) throws EASBizException {
		// 条码系统连接
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);// 得到条码系统连接
			if (conn == null) {
				throw new Exception("请确认系统连接参数设置正确!");
			}
			//设定时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(beginDate + " 00:00:00");
			Date date3 = sdf.parse(endDate + " 00:00:00");
			Calendar c=Calendar.getInstance();
			c.setTime(date3);
			c.add(Calendar.DATE, 1);
			Date date2=c.getTime();
			IStorageOrgUnit iss = null;
			if(ctx==null) {
				iss=StorageOrgUnitFactory.getRemoteInstance();
			}else{
				iss=StorageOrgUnitFactory.getLocalInstance(ctx);
			}
			StorageOrgUnitInfo orgInfo = iss.getStorageOrgUnitInfo(new ObjectUuidPK(companyID));
			String companyNum=orgInfo.getNumber();
			
			//领料出库单导入
			ArrayList<Integer> tempBillIDList = new ArrayList<Integer>();
			HashSet<String> sourceBillIDs = new HashSet<String>();// 取关联Temp的生产订单的EASID
			HashMap<String, BigDecimal> qtyMap = new HashMap<String, BigDecimal>();// 数量
			BigDecimal qty = BigDecimal.ZERO;// 同一物料的累计数量
			
			// 获取中控数据
			PreparedStatement ptm = conn.prepareStatement(getQueryStr(),ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ptm.setDate(1, new java.sql.Date(date.getTime()));
			ptm.setDate(2, new java.sql.Date(date2.getTime()));
			ResultSet rs = ptm.executeQuery();
			//初始化
			sourceBillIDs.clear();
			qtyMap.clear();
			//条码--领料出库导入
			String orderBillID = null, orderBillIDKeep = null;// Temp单据编码
			String materialID;
			 
			BigDecimal materialQty=BigDecimal.ZERO;
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				String billType = "领料出库单";
				orderBillID = rs.getString("order");// 生产订单id
				materialID=rs.getString("materialNum");
				qty=rs.getBigDecimal("actualWeight");//数量
				if(qty==null) {
					qty=BigDecimal.ZERO;
				}
				
				if(orderBillID==null||orderBillID.equals("")){
					throw new BOSException("生产订单id不能为空");
				}
				if (StringUtils.isBlank(orderBillIDKeep)) {
					orderBillIDKeep = orderBillID;
					sourceBillIDs.add(orderBillID);// 生产订单id
				}
				if(!qtyMap.containsKey(materialID)){
					qtyMap.put(materialID, BigDecimal.ZERO);
				}
				materialQty=qtyMap.get(materialID);
				
				if(rs.getRow() == (count)) {
					sourceBillIDs.add(orderBillID);// eas
					materialQty=materialQty.add(qty);//物料合计数量
					qtyMap.put(materialID,materialQty);
					tempBillIDList.add(rs.getInt("id"));
				}
				
				// 使用botp导入
				if (!orderBillIDKeep.equals(orderBillID)||rs.getRow() == (count)) {
					System.out.println("调用Botp生成领料出库单");
					if(sourceBillIDs!=null&&sourceBillIDs.size()>0&&!qtyMap.isEmpty()){
						exeImportByBotp(ctx, conn, sourceBillIDs, qtyMap, tempBillIDList);
						updateHadImportFlag(conn, tempBillIDList);
						//EASWUtils.insertHasImported(ctx, tempBillIDList, billType);
						//break;
					}
					sourceBillIDs.clear();
					qtyMap.clear();
					orderBillIDKeep = orderBillID;
				}
				sourceBillIDs.add(orderBillID);// eas
				materialQty=materialQty.add(qty);//物料合计数量
				qtyMap.put(materialID,materialQty);
				tempBillIDList.add(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/*
	 * 反写读写标志
	 */
	private void updateHadImportFlag(Connection conn,ArrayList<Integer> idList) throws SQLException{
		String ids="";
		for(Integer id:idList) {	
			if(ids.length()>0) {
				ids+=",";
			}
			ids+=id;
		}
		if(ids=="") {
			ids="0";
		}
		conn.createStatement().execute("update "+getTempHeadTable()+" set readFlag=1 where id in ("+ids+")");
	}
	/**
	 * 执行单据转换
	 * 
	 * @param ctx
	 * @throws ClassNotFoundException
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void exeImportByBotp(Context ctx, Connection conn, HashSet<String> sourceBillIDs, HashMap<String, BigDecimal> qtyMap,
			ArrayList<Integer> tempBillNumList) throws BOSException, ClassNotFoundException, EASBizException {
		Boolean isCoust = false;
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Boolean isSuccess = true;
		String msg = null;
		String sourceBillID = null;
		if (sourceBillIDs.iterator().hasNext()) {
			sourceBillID = sourceBillIDs.iterator().next();
		}
		filter.getFilterItems().add(new FilterItemInfo("number", sourceBillIDs, CompareType.INCLUDE));
		ev.setFilter(filter);
		CoreBillBaseCollection col = EASWUtils.getIInstance(ctx, getEASSourceBosType()).getCoreBillBaseCollection(ev);
		if(col==null||col.size()<=0) {
			//return;
		}
		
		IMaterialReqBill imrs =null;
		if(ctx!=null) {
			imrs=MaterialReqBillFactory.getLocalInstance(ctx);
		}else{
			imrs=MaterialReqBillFactory.getRemoteInstance();
		}

		// ****************
		MaterialReqBillInfo info = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		if(ctx!=null) {
			btp = BTPManagerFactory.getLocalInstance(ctx);
		}else{
			btp = BTPManagerFactory.getRemoteInstance();
		}
		if(col==null||col.size()<=0){
//			info = new MaterialReqBillInfo();
			info =  (MaterialReqBillInfo) MaterialReqBillFactory.getLocalInstance(ctx).createNewData(true);
			info.setStorageOrgUnit(StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK("eO1vXVQPSMOAeL4Et/RpxcznrtQ=")));
			//info.
			isCoust = true;
		}else{
			result = btp.transform(col, getEASBosType());
			info = (MaterialReqBillInfo) result.getBills().getObject(0);
		}
		
		// *******************

		// MaterialReqBillInfo info = (MaterialReqBillInfo)
		// EASWUtils.createToDestBill(ctx, col, getEASBosType());// 生成关联单据

		MaterialReqBillEntryInfo entryInfo;
		IMaterial ims =null;
		if(ctx!=null){
			ims=MaterialFactory.getLocalInstance(ctx);
		}else{
			ims=MaterialFactory.getRemoteInstance();
		}
		IManufactureOrder imf = null;
		if(ctx!=null) {
			imf=ManufactureOrderFactory.getLocalInstance(ctx);// 成本对象为生产订单上的成本对象
		}else {
			imf=ManufactureOrderFactory.getRemoteInstance();
		}
		SelectorItemCollection slr = new SelectorItemCollection();
		slr.add("*");
		slr.add(new SelectorItemInfo("costObject.*"));
		//ManufactureOrderInfo mfoinfo = imf.getManufactureOrderInfo(new ObjectUuidPK(sourceBillID), slr);
		// 生成关联单据
		if (info == null) {
			return;
		}
		//String id = info.getString("id");
		
		//单据编码@20161219
		if(StringUtils.isBlank(info.getNumber())) {
		//info.setNumber(getNewNumber(info, SysContext.getSysContext().getCurrentCtrlUnit().getString("id"), ""));
			info.setNumber(getNewNumber(info, ContextUtil.getCurrentCtrlUnit(ctx).getString("id"), "",ctx));
			//AppCommon ap = null ;
		//	info.setNumber(ap.getAutoCode(ctx,info,ContextUtil.getCurrentCtrlUnit(ctx).getString("id")));
			
		}

		// 设置单据体
		info.setDescription("中控接口导入:"+sourceBillID);// 备注
		info.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));// 设置成本中心领料部门
		IBillType ibys =null;
		if(ctx!=null) {
			ibys=BillTypeFactory.getLocalInstance(ctx);
		}else{
			ibys=BillTypeFactory.getRemoteInstance();
		}
		info.setBillType(ibys.getBillTypeInfo(new ObjectUuidPK("50957179-0105-1000-e000-0163c0a812fd463ED552")));
		info.setIsReversed(false);
		info.setPurchaseType(PurchaseTypeEnum.PURCHASE);
		//yumingxu
		info.setBizType(BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("0rSFjAEeEADgAAyMwKgSQiQHQ1w=")));
		info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("DawAAAAPoCuwCNyn")));
		
		//modify @20161212 删除不包含的物料
		/*for (int index = 0; index < info.getEntry().size();) {
			if (index >= info.getEntry().size()) {// 超出分录总行数
				break;
			}
			entryInfo = info.getEntry().get(index);
			if (!qtyMap.containsKey(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber())) {// 导入的记录中不含有采购入库单分录的物料 
				info.getEntry().removeObject(index);

				continue;
			}
			
			index++;
		}*/
		
		//设置更新类型--普通入库2016-03-05新增
		//****add @20160305
		  TransactionTypeInfo transactionType = info.getTransactionType();
//		  InvUpdateTypeInfo invUpdateTypeInfo = null;
//		  try {
//			  ITransactionType iinvs =null;
//			  if(ctx!=null){
//				  iinvs=TransactionTypeFactory.getLocalInstance(ctx);
//			  }else{
//				  iinvs=TransactionTypeFactory.getRemoteInstance();
//			  }
//			  invUpdateTypeInfo = iinvs.getDefaultInvUpdateType(transactionType.getId().toString());
//		  }
//		  catch (Exception e)
//		  {
//			  e.printStackTrace();
//		  }
		 
		  
		  MaterialReqBillEntryInfo entryInfoClone=null;
		// 设置领料出库分录字段值
		for (int index = 0; index < info.getEntry().size();) {
			entryInfo = info.getEntry().get(index);
			//add@20161212 删除不包含的物料
			if (!qtyMap.containsKey(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber())) {// 导入的记录中不含有分录的物料 
				info.getEntry().removeObject(index);
				continue;
			}
			//删除数量为0的物料
			if(entryInfoClone==null) {
				entryInfoClone=(MaterialReqBillEntryInfo) entryInfo.clone();
				entryInfoClone.setId(null);
				entryInfoClone.setSeq(0);
			}
			//add end
			entryInfo.setQty(qtyMap.get(entryInfo.getMaterial().getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
			WarehouseInfo warehouse = EASWUtils.getDefaultLLWareHouse(ctx, info.getStorageOrgUnit().getString("id"));//ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
			if (warehouse == null) {
				warehouse=EASWUtils.getDefaultByMaterial(ctx,info.getStorageOrgUnit().getString("id") ,	entryInfo.getMaterial().getId().toString());//ContextUtil.getCurrentOrgUnit(ctx).getId().toString()
//				warehouse = EASWUtils.getDefaultLLWareHouse(ctx, info.getStorageOrgUnit().getString("id"));//ContextUtil.getCurrentOrgUnit(ctx).getId().toString()
			}
			entryInfo.setWarehouse(warehouse);// 物料默认仓库

			//entryInfo.setCostObject(mfoinfo.getCostObject());
			entryInfo.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));//设置成本中心--
																		// 根据库存组织获取默认成本中心
			entryInfo.setIsPresent(false);
			
			//返工类型 物料类别为0201饲料产品的
			if(getGroupLongNumberByMaterialID(ctx,entryInfo.getMaterial().getString("id")).indexOf("0201")==0) {
				entryInfo.setIsReWork(true);
			}
			//更新类型
			// entryInfo.setInvUpdateType(invUpdateTypeInfo);//更新类型 add@20160305
			  //*****
			 index++;
			 //删除已经设置的物料
			 qtyMap.remove(entryInfo.getMaterial().getNumber());
		}
		try {
			//add@20161221 没有中控新增的物料则新增
			MaterialInfo mInfo;
			for(Map.Entry<String,BigDecimal> entry:qtyMap.entrySet()) {
				mInfo=getMaterialInfoByNum(ctx, ims, entry.getKey());
				if(mInfo==null) {
					continue;
				}
				//entryInfo=(MaterialReqBillEntryInfo) entryInfoClone.clone();
				entryInfo = new MaterialReqBillEntryInfo();
				entryInfo.setMaterial(mInfo);
				entryInfo.setQty(qtyMap.get(entryInfo.getMaterial().getNumber()));
				entryInfo.setBaseQty(entryInfo.getQty());
				entryInfo.setUnit(mInfo.getBaseUnit());
				entryInfo.setBaseUnit(mInfo.getBaseUnit());
				WarehouseInfo warehouse = EASWUtils.getDefaultLLWareHouse(ctx, info.getStorageOrgUnit().getString("id"));//ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if (warehouse == null) {
					warehouse=EASWUtils.getDefaultByMaterial(ctx,info.getStorageOrgUnit().getString("id") ,	entryInfo.getMaterial().getId().toString());//ContextUtil.getCurrentOrgUnit(ctx).getId().toString()
				}
				entryInfo.setWarehouse(warehouse);// 物料默认仓库
	
				//entryInfo.setCostObject(mfoinfo.getCostObject());
				entryInfo.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));//设置成本中心--
																			// 根据库存组织获取默认成本中心
				entryInfo.setIsPresent(false);
				
//				//返工类型 物料类别为0201饲料产品的
//				if(getGroupLongNumberByMaterialID(ctx,entryInfo.getMaterial().getString("id")).indexOf("02!0201")==0) {
//					entryInfo.setIsReWork(true);
//				}
				//更新类型
				 //entryInfo.setInvUpdateType(invUpdateTypeInfo);//更新类型 add@20160305
				 //添加到新分录
				 info.getEntries().addObject(entryInfo);
			}
		}catch(Exception er) {
			er.printStackTrace();
		}

		IObjectPK pk = null;
		try {
			pk = null;
			//pk = imrs.addnew(info);
			pk = imrs.save(info);
			System.out.println("成功导入ID为"+pk.toString()+"的出库单");
			//imrs.submit(info);
//			if(pk != null){
//				MaterialReqBillInfo billInfo = imrs.getMaterialReqBillInfo(pk);
//				//imrs.submit(billInfo);
//			}
			if(isCoust){
				System.out.println("导入ID为"+pk.toString()+"的自定义生产订单出库单");
			}else{
				btp.submitRelations(result.getBOTRelationCollection());
			}
			msg="导入领料出库单成功！";
		} catch (Exception e1) {
			isSuccess = false;
			msg = e1.getMessage();
			if (pk != null) {
				if(ctx!=null) {
					MaterialReqBillFactory.getLocalInstance(ctx).delete(pk);
				}else{
					MaterialReqBillFactory.getRemoteInstance().delete(pk);
				}
			}
			throw new EASBizException(new NumericExceptionSubItem("001", e1.getMessage()));
		} finally {
			LogBean logBean = new LogBean();
			logBean.setOrgUnitID(ctx!=null?ContextUtil.getCurrentCtrlUnit(ctx).getId().toString():SysContext.getSysContext().getCurrentCtrlUnit().getString("id"));
			logBean.setBosType(info.getBOSType().toString());
			logBean.setEasBillID(info.getId().toString());
			logBean.setDirection(LogBean.Direction_Import);
			logBean.setSuccess(isSuccess);
			logBean.setMsg(msg);
			//EASWUtils.insertLogs(ctx, logBean);// 插入日志
		}
	}
	/**
	 * 根据编码获取物料
	 * @param ctx
	 * @param number
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	private MaterialInfo getMaterialInfoByNum(Context ctx,IMaterial ims,String number){
		try {
			String str="select fid from t_bd_material where fnumber='"+number+"'";
			ISQLExecutor is =null;
			if(ctx==null){
				is=SQLExecutorFactory.getRemoteInstance(str);
			}else{
				is=SQLExecutorFactory.getLocalInstance(ctx, str);
			}
			IRowSet rs = is.executeSQL();
			if(rs.next()) {
				return ims.getMaterialInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	 protected String getNewNumber( IObjectValue model, String strCompanyID, String customString,Context ctx) throws BOSException, EASBizException {
		 /*  258 */     ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		 /*      */ 
		 /*  260 */     SCMBillBaseInfo aSCMBillBaseInfo = (SCMBillBaseInfo)model;
		 /*  261 */     String number = "";
		 /*  262 */     String strBindProp = null;//getBindingProperty(ctx);
		 /*  263 */     if ((strBindProp != null) && (strBindProp.trim().length() > 0)) {
		 /*  264 */       number = iCodingRuleManager.getNumber(aSCMBillBaseInfo, strCompanyID, strBindProp, customString);
		 /*  265 */       aSCMBillBaseInfo.setNumber(number);
		 /*      */     } else {
		 /*  267 */       number = iCodingRuleManager.getNumber(aSCMBillBaseInfo, strCompanyID, customString);
		 /*  268 */       aSCMBillBaseInfo.setNumber(number);
		 /*      */     }
		 /*      */ 
		 /*  271 */     ObjectUuidPK pk = new ObjectUuidPK(aSCMBillBaseInfo.getId());
		 /*  272 */     if (isSameNumber(pk, aSCMBillBaseInfo,ctx))
		 /*      */     {
		 /*  274 */       String newNumber = "";
		 /*  275 */       if ((strBindProp != null) && (strBindProp.trim().length() > 0)) {
		 /*  276 */         newNumber = iCodingRuleManager.getNumber(aSCMBillBaseInfo, strCompanyID, strBindProp, customString);
		 /*      */       }
		 /*      */       else {
		 /*  279 */         newNumber = iCodingRuleManager.getNumber(aSCMBillBaseInfo, strCompanyID, customString);
		 /*      */       }
		 /*      */ 
		 /*  282 */       if (newNumber.equals(aSCMBillBaseInfo.getNumber()))
		 /*      */       {
		 /*  284 */         throw new SCMBillException(SCMBillException.NUMBERRULEERROR);
		 /*      */       }
		 /*  286 */       number = newNumber;
		 /*  287 */       aSCMBillBaseInfo.setNumber(newNumber);
		 /*  288 */       if (isSameNumber(pk, aSCMBillBaseInfo,ctx)) {
		 /*  289 */         return getNewNumber( aSCMBillBaseInfo, strCompanyID, customString,ctx);
		 /*      */       }
		 /*      */     }
		 /*  292 */     return number;
		 /*      */   }

	 /*      */   protected boolean isSameNumber(IObjectPK pk, IObjectValue model,Context ctx)
	 /*      */     throws EASBizException, BOSException
	 /*      */   {
	 /*  310 */     SCMBillBaseInfo aSCMBillBaseInfo = (SCMBillBaseInfo)model;
	 /*  311 */     FilterInfo filter = new FilterInfo();
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */ 
	 /*  320 */     FilterItemInfo filterItem = null;
	 /*  321 */     if (aSCMBillBaseInfo.getNumber() == null)
	 /*  322 */       filterItem = new FilterItemInfo("number", aSCMBillBaseInfo.getNumber(), CompareType.EQUALS);
	 /*      */     else {
	 /*  324 */       filterItem = new FilterItemInfo("number", aSCMBillBaseInfo.getNumber().trim(), CompareType.EQUALS);
	 /*      */     }
	 /*      */ 
	 /*  327 */     filter.getFilterItems().add(filterItem);
	 /*  328 */     if (aSCMBillBaseInfo.getId() != null) {
	 /*  329 */       filterItem = new FilterItemInfo("id", aSCMBillBaseInfo.getId(), CompareType.NOTEQUALS);
	 /*  330 */       filter.getFilterItems().add(filterItem);
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */
	 /*      */     }
	 /*      */ 
	 /*  345 */     if (aSCMBillBaseInfo.getCU() != null) {
	 /*  346 */       filterItem = new FilterItemInfo("CU", aSCMBillBaseInfo.getCU().getId().toString(), CompareType.EQUALS);
	 /*  347 */       filter.getFilterItems().add(filterItem);
	 /*      */     } else {
	 /*  349 */       filterItem = new FilterItemInfo("CU", null, CompareType.EQUALS);
	 /*  350 */       filter.getFilterItems().add(filterItem);
	 /*      */
	 /*      */
	 /*      */     }
	 /*      */ 
//	 /*  355 */     if ((getBindingProperty(ctx) != null) && (getBindingProperty(ctx).trim().length() > 0) && (aSCMBillBaseInfo.get(getBindingProperty(ctx)) != null)) {
//	 /*  356 */       filterItem = new FilterItemInfo(getBindingProperty(ctx), getBindingPropertyValue(aSCMBillBaseInfo), CompareType.EQUALS);
//	 /*  357 */       filter.getFilterItems().add(filterItem);
//	 /*      */     }
	 /*  359 */     StringBuffer sb = new StringBuffer();
	 /*  360 */     for (int i = 0; i < filter.getFilterItems().size(); ++i) {
	 /*  361 */       if (i != 0)
	 /*  362 */         sb.append(new StringBuilder().append(" and #").append(i).toString());
	 /*      */       else
	 /*  364 */         sb.append(new StringBuilder().append("#").append(i).toString());
	 /*      */     }
	 /*  366 */     filter.setMaskString(sb.toString());
	 /*      */ 
	 /*  368 */     EntityViewInfo view = new EntityViewInfo();
	 /*  369 */     view.setFilter(filter);
	 /*  370 */     SorterItemCollection sorter = new SorterItemCollection();
	 /*  371 */     sorter.add(new SorterItemInfo("id"));
	 /*      */
	 /*      */
	 /*      */ 
	 /*  375 */     return MaterialReqBillFactory.getLocalInstance(ctx).checkLineExist(new ObjectUuidPK(aSCMBillBaseInfo.getId()));
	 /*      */   }
	 
	 
	/***
	 * 通过物料编码获取类别长编码
	 * @param ctx
	 * @param materialID
	 * @return
	 */
	private String getGroupLongNumberByMaterialID(Context ctx,String materialID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tmg.FLongNumber from T_BD_MaterialGroup tmg")
			.append(" inner join t_bd_material tm on tm.FMaterialGroupID=tmg.fid")
			.append(" where tm.fid='").append(materialID).append("'");
			IRowSet rs=null;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				return rs.getString("flongnumber");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return "";
	}

	public String getEASBosType() {
		// 领料出库单的BosType
		return "500AB75E";
	}

	public String getEASSourceBosType() {
		// 生产订单BosType
		return "1D0D80DD";
	}

	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return "";
	}

	// 条码系统中间库
	public String getTempHeadTable() {
		return "t_materialCost";
	}

//	// 牧羊系统中间库
//	public String getMYTempHeadTable() {
//		return "bomData";
//	}

	// 中控系统中间库数据查询sql
	public String getQueryStr() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");// fplid,plid,plno,ylid,ylzl,llyl,gc,mz,pz,zsd,
		// tlzt,clyc,tlno,wlfl,clr,ltzl,erpbillno
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and btime>=?");
		sql.append(" and etime<?");// 领料日期
		//sql.append(" and etime<?");// 领料日期
		sql.append(" order by ID");
		return sql.toString();
	}

	/**
	 * 得到来源 EAS 单据id
	 * 
	 * @param
	 */
	public String getSourceBillID(Context ctx, String orgUnitID, String tempSourceBillNum) {
		String result = "";
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid");
		sql.append(" from ").append(getTempSourceTable());
		sql.append(" where fnumber='").append(tempSourceBillNum).append("'");
		sql.append(" and FControlUnitID='").append(orgUnitID).append("'");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				result = rs.getString("fid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getTempSourceTable() {
		// 生产订单表名
		return "T_MM_ManufactureOrder";
	}
//	public String getQueryStr() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
