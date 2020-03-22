package com.kingdee.eas.weighbridge.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.FieldType;
import com.kingdee.eas.weighbridge.InStorageBillEntryDetailCollection;
import com.kingdee.eas.weighbridge.InStorageBillEntryDetailInfo;
import com.kingdee.eas.weighbridge.InStorageBillEntryFactory;
import com.kingdee.eas.weighbridge.InStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.InStorageBillFactory;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.weighbridge.StorageBillEditBillEntryInfo;
import com.kingdee.eas.weighbridge.StorageBillEditBillFactory;
import com.kingdee.eas.weighbridge.StorageBillEditBillInfo;
import com.kingdee.eas.weighbridge.StorageBillType;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class weightbridgeFacadeControllerBean extends AbstractweightbridgeFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.weightbridgeFacadeControllerBean");

    /**
     * 根据订单编码获得 订单相关信息 
     *dx修改为派车单
     */
	@Override
	protected Map _getPurorderInfoByNumber(Context ctx,
			String number,String searchCarNumber,String beginDateStr,String endDateStr) throws BOSException {
		Map<String,OrderWeightInfo> resultMap = new LinkedHashMap<String,OrderWeightInfo>();
		
		
		try{
			
				StringBuilder sql = new StringBuilder();
				sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.FName_l2 supplierName,ts.FID supplierID,ts.FNumber supplierNumber,tc.fid carid,");
				sql.append(" t.CFCarNum carNumber ");
				//sql.append(" ");
				sql.append(" from CT_DX_CarSendBill t ");
				sql.append(" inner join CT_DX_StapleSupplier te on t.CFStaplesupplierID = te.fid ");
				sql.append(" inner join t_bd_supplier ts on te.CFSupplierID = ts.fid ");
				sql.append(" inner join CT_PUB_Car tc on t.CFCarID = tc.fid ");
				sql.append(" where t.fnumber not like '*%' and t.FBillStatus = 2  and t.CFIsGross !=1 ");
				sql.append(" and t.FCompanyID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
				if(StringUtils.isNotBlank(number)){
					sql.append(" and  t.fnumber like '%");
					sql.append(number);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(searchCarNumber)){
					sql.append(" and  t.CFCarNum like '%");
					sql.append(searchCarNumber);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(beginDateStr)){
					sql.append(" and  t.fbizdate >= { ts'");
					sql.append(beginDateStr);
					sql.append("'} ");
				}
				if(StringUtils.isNotBlank(endDateStr)){
					sql.append(" and  t.fbizdate <= { ts'");
					sql.append(endDateStr);
					sql.append(" 23:59:59'} ");
				}
				
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				if(rs.size() < 1){
					throw new BOSException("未查询到的相应派车单，请检查输入是否正确");
				}
//				if(rs.size() > 1){
//					throw new BOSException("该订单存在多条分录，不能进行采购过磅，请检查订单号是否输入正确");
//				}
				// 取数
				while(rs.next()){
					OrderWeightInfo orderInfo = new OrderWeightInfo();
					String billID = rs.getString("billID");
					//String entryID= rs.getString("entryID");
					String billNumber = rs.getString("billNumber");
					String supplierID = rs.getString("supplierID");
					String supplierNumber = rs.getString("supplierNumber");
					String supplierName = rs.getString("supplierName");
					String carNumber = rs.getString("carNumber");
					String carId = rs.getString("carid");
					//String materialID = rs.getString("materialID");
					//String materialNumber = rs.getString("materialNumber");
					//String materialName = rs.getString("materialName");
					Date fbizdate = rs.getDate("fbizdate");
					//int FBaseStatus = rs.getInt("FBaseStatus");
					//BigDecimal baseQty = rs.getBigDecimal("baseQty");
//					if(FBaseStatus < 4){
//						throw new BOSException("该订单尚未审核，请确认订单号录入是否准确。");
//					}
					orderInfo.setBizDate(fbizdate);
					orderInfo.setOrderID(billID);
					orderInfo.setOrderNumber(billNumber);
					orderInfo.setCarNumber(carNumber);
//					orderInfo.setMaterialID(materialID);
//					orderInfo.setMaterialName(materialName);
//					orderInfo.setMaterialNumber(materialNumber);
					//orderInfo.setOrderBaseQty(baseQty);
					orderInfo.setCusSuppID(supplierID);
					orderInfo.setCusSuppName(supplierName);
					orderInfo.setCusSuppNumber(supplierNumber);
					orderInfo.setCarId(carId);
					//orderInfo.setEntryID(rs.getString("entryID"));
					//BillBaseStatusEnum baseStatus = BillBaseStatusEnum.getEnum(FBaseStatus);
					//orderInfo.setBaseStatusEnum(baseStatus);
					resultMap.put(billID, orderInfo);//billID
				}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return resultMap;
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.weighbridge.app.AbstractweightbridgeFacadeControllerBean#_getNewPurorderInfoByNumber(com.kingdee.bos.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	protected Map _getNewPurorderInfoByNumber(Context ctx, String number,
			String carNumber, String beginDate, String endDate)
			throws BOSException {
		// TODO Auto-generated method stub
//		return super._getNewPurorderInfoByNumber(ctx, number, carNumber, beginDate,
//				endDate);
		Map<String,OrderWeightInfo> resultMap = new LinkedHashMap<String,OrderWeightInfo>();
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.fid supplierID,ts.fnumber supplierNumber,ts.fname_l2 supplierName, ");
			sql.append(" t.cfcarnumber carNumber,tm.fid materialID,tm.fnumber materialNumber,tm.fname_l2 materialName,te.fbaseqty baseQty ,t.FBaseStatus ");
			sql.append(" ,te.fid entryID");
			sql.append(" from T_SM_PurOrder t inner join T_SM_PurOrderEntry te on t.fid = te.fparentid ");
			sql.append(" inner join t_bd_supplier ts on t.fsupplierid = ts.fid inner join t_bd_material tm on te.fmaterialid = tm.fid ");
			sql.append(" where t.fnumber not like '*%' and t.FBaseStatus = 4  and te.FTotalReceiptQty <=0  and (t.CFisHasWgtBill = 0 or t.CFisHasWgtBill is null)");
			sql.append(" and t.FCompanyOrgUnitID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
			if(StringUtils.isNotBlank(number)){
				sql.append(" and  t.fnumber like '%");
				sql.append(number);
				sql.append("%' ");
			}
			if(StringUtils.isNotBlank(carNumber)){
				sql.append(" and  t.cfcarnumber like '%");
				sql.append(carNumber);
				sql.append("%' ");
			}
			if(StringUtils.isNotBlank(beginDate)){
				sql.append(" and  t.fbizdate >= { ts'");
				sql.append(beginDate);
				sql.append("'} ");
			}
			if(StringUtils.isNotBlank(endDate)){
				sql.append(" and  t.fbizdate <= { ts'");
				sql.append(endDate);
				sql.append(" 23:59:59'} ");
			}
			
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.size() < 1){
				throw new BOSException("该订单号未查询到的采购订单，请检查输入是否正确");
			}
//			if(rs.size() > 1){
//				throw new BOSException("该订单存在多条分录，不能进行采购过磅，请检查订单号是否输入正确");
//			}
			// 取数
			while(rs.next()){
				OrderWeightInfo orderInfo = new OrderWeightInfo();
				String billID = rs.getString("billID");
				String entryID= rs.getString("entryID");
				String billNumber = rs.getString("billNumber");
				String supplierID = rs.getString("supplierID");
				String supplierNumber = rs.getString("supplierNumber");
				String supplierName = rs.getString("supplierName");
				String carNumbers = rs.getString("carNumber");
				String materialID = rs.getString("materialID");
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				Date fbizdate = rs.getDate("fbizdate");
				int FBaseStatus = rs.getInt("FBaseStatus");
				BigDecimal baseQty = rs.getBigDecimal("baseQty");
//				if(FBaseStatus < 4){
//					throw new BOSException("该订单尚未审核，请确认订单号录入是否准确。");
//				}
				orderInfo.setBizDate(fbizdate);
				orderInfo.setOrderID(billID);
				orderInfo.setOrderNumber(billNumber);
				orderInfo.setCarNumber(carNumbers);
				orderInfo.setMaterialID(materialID);
				orderInfo.setMaterialName(materialName);
				orderInfo.setMaterialNumber(materialNumber);
				orderInfo.setOrderBaseQty(baseQty);
				orderInfo.setCusSuppID(supplierID);
				orderInfo.setCusSuppName(supplierName);
				orderInfo.setCusSuppNumber(supplierNumber);
				orderInfo.setEntryID(rs.getString("entryID"));
				BillBaseStatusEnum baseStatus = BillBaseStatusEnum.getEnum(FBaseStatus);
				orderInfo.setBaseStatusEnum(baseStatus);
				resultMap.put(billID, orderInfo);//billID
			}
		
	}catch(SQLException sqle){
		sqle.printStackTrace();
		throw new BOSException(sqle);
	}
	return resultMap;
	}

	@Override
	protected Map _getCarSendTara(Context ctx,
			String number,String searchCarNumber,String beginDateStr,String endDateStr) throws BOSException {
		Map<String,OrderWeightInfo> resultMap = new LinkedHashMap<String,OrderWeightInfo>();
		
		
		try{
			
				StringBuilder sql = new StringBuilder();
				sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.FName_l2,ts.FName_l2 supplierName,ts.FID supplierID,ts.FNumber supplierNumber,tc.fid carid,");
				sql.append(" t.CFCarNum carNumber ");
				//sql.append(" ");
				sql.append(" from CT_DX_CarSendBill t ");
				sql.append(" inner join CT_DX_StapleSupplier te on t.CFStaplesupplierID = te.fid ");
				sql.append(" inner join t_bd_supplier ts on te.CFSupplierID = ts.fid ");
				sql.append(" inner join CT_PUB_Car tc on t.CFCarID = tc.fid ");
				//sql.append(" inner join t_bd_supplier ts on t.fsupplierid = ts.fid inner join t_bd_material tm on te.fmaterialid = tm.fid ");
				sql.append(" where t.fnumber not like '*%' and t.FBillStatus = 2  and t.CFIsTara !=1 ");
				sql.append(" and t.FCompanyID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
				if(StringUtils.isNotBlank(number)){
					sql.append(" and  t.fnumber like '%");
					sql.append(number);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(searchCarNumber)){
					sql.append(" and  t.CFCarNum like '%");
					sql.append(searchCarNumber);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(beginDateStr)){
					sql.append(" and  t.fbizdate >= { ts'");
					sql.append(beginDateStr);
					sql.append("'} ");
				}
				if(StringUtils.isNotBlank(endDateStr)){
					sql.append(" and  t.fbizdate <= { ts'");
					sql.append(endDateStr);
					sql.append(" 23:59:59'} ");
				}
				
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				if(rs.size() < 1){
					throw new BOSException("未查询到的相应派车单，请检查输入是否正确");
				}
//				if(rs.size() > 1){
//					throw new BOSException("该订单存在多条分录，不能进行采购过磅，请检查订单号是否输入正确");
//				}
				// 取数
				while(rs.next()){
					OrderWeightInfo orderInfo = new OrderWeightInfo();
					String billID = rs.getString("billID");
					//String entryID= rs.getString("entryID");
					String billNumber = rs.getString("billNumber");
					String supplierID = rs.getString("supplierID");
					String supplierNumber = rs.getString("supplierNumber");
					String supplierName = rs.getString("supplierName");
					String carNumber = rs.getString("carNumber");
					String carId = rs.getString("carid");
					//String materialID = rs.getString("materialID");
					//String materialNumber = rs.getString("materialNumber");
					//String materialName = rs.getString("materialName");
					Date fbizdate = rs.getDate("fbizdate");
					//int FBaseStatus = rs.getInt("FBaseStatus");
					//BigDecimal baseQty = rs.getBigDecimal("baseQty");
//					if(FBaseStatus < 4){
//						throw new BOSException("该订单尚未审核，请确认订单号录入是否准确。");
//					}
					orderInfo.setBizDate(fbizdate);
					orderInfo.setOrderID(billID);
					orderInfo.setOrderNumber(billNumber);
					orderInfo.setCarNumber(carNumber);
					orderInfo.setCarId(carId);
//					orderInfo.setMaterialID(materialID);
//					orderInfo.setMaterialName(materialName);
//					orderInfo.setMaterialNumber(materialNumber);
					//orderInfo.setOrderBaseQty(baseQty);
					orderInfo.setCusSuppID(supplierID);
					orderInfo.setCusSuppName(supplierName);
					orderInfo.setCusSuppNumber(supplierNumber);
					//orderInfo.setEntryID(rs.getString("entryID"));
					//BillBaseStatusEnum baseStatus = BillBaseStatusEnum.getEnum(FBaseStatus);
					//orderInfo.setBaseStatusEnum(baseStatus);
					resultMap.put(billID, orderInfo);//billID
				}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return resultMap;
	}

	@Override
	protected Map _getSaleorderInfoByNumber(Context ctx, String number,String carNumber, String beginDateStr, String endDateStr)		throws BOSException {
Map<String,OrderWeightInfo> resultMap = new LinkedHashMap<String,OrderWeightInfo>();
		
		
		try{
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
			 Calendar cal= Calendar.getInstance();
				StringBuilder sql = new StringBuilder();
				
//				sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.fid supplierID,ts.fnumber supplierNumber,ts.fname_l2 supplierName, ");
//				sql.append(" t.cflicensePlateNum carNumber,sum(te.fbaseqty)-isnull(sum(te.FASSISTQTY*tp.FQty),0) baseQty ,t.FBaseStatus ");
//				sql.append(" ,isnull(sum(te.FASSISTQTY),0) bagQty ");
//				sql.append(" from t_sd_saleOrder t inner join T_sd_saleOrderEntry te on t.fid = te.fparentid ");
//				sql.append(" inner join t_bd_customer ts on t.forderCustomerID = ts.fid ");
//				
//				sql.append(" inner join T_BD_Material tm on tm.FID = te.FMaterialID  ");
//				sql.append(" left join CT_DX_PackbasicEntry tp on tp.FMaterialNumID = tm.FID ");
//				
//				sql.append(" where 1=1 ");
//				sql.append(" and t.FCompanyOrgUnitID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
//				
//				
//				
				
				//1102 修改
				sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.fid supplierID,ts.fnumber supplierNumber,ts.fname_l2 supplierName, ");
				sql.append(" t.cflicensePlateNum carNumber,sum(te.fbaseqty)+isnull(sum(te.FASSISTQTY*tp.FQty),0) baseQty ,t.FBaseStatus ");
				sql.append(" ,isnull(sum(te.FASSISTQTY),0) bagQty ");
				sql.append(" from T_IM_SaleIssueBill t inner join T_IM_SaleIssueEntry te on t.fid = te.fparentid ");
				sql.append(" inner join t_bd_customer ts on t.FCustomerID = ts.fid ");
				
				sql.append(" inner join T_BD_Material tm on tm.FID = te.FMaterialID  ");
				sql.append(" left join CT_DX_PackbasicEntry tp on tp.FMaterialNumID = tm.FID ");
				
				sql.append(" where 1=1 ");
				sql.append(" and t.FStorageOrgUnitID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
				
				
				
				
				
				
				if(StringUtils.isNotBlank(number)){
					sql.append(" and  t.fnumber like '%");
					sql.append(number);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(carNumber)){
					sql.append(" and  t.cflicensePlateNum like '%");
					sql.append(carNumber);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(beginDateStr)){
					/*cal.setTime(sdf.parse(beginDateStr));
					cal.add(Calendar.DAY_OF_MONTH,-7);*/
					sql.append(" and  t.fbizdate >= { ts'");
					sql.append(beginDateStr);
					sql.append("'} ");
				}
				if(StringUtils.isNotBlank(endDateStr)){
					sql.append(" and  t.fbizdate <= { ts'");
					sql.append(endDateStr);
					sql.append(" 23:59:59'} ");
				}
				sql.append(" group by t.fid,t.fnumber,t.fbizdate,ts.fid,ts.fnumber,ts.fname_l2,t.cflicensePlateNum,t.FBaseStatus ");
				sql.append(" order by t.fnumber");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				if(rs.size() < 1){
//					throw new BOSException("该订单号未查询到的销售订单，请检查输入是否正确");
				}
//				if(rs.size() > 1){
//					throw new BOSException("该订单存在多条分录，不能进行采购过磅，请检查订单号是否输入正确");
//				}
				// 取数
				while(rs.next()){
					OrderWeightInfo orderInfo = new OrderWeightInfo();
					String billID = rs.getString("billID");
					//String entryID= rs.getString("entryID");
					String billNumber = rs.getString("billNumber");
					String supplierID = rs.getString("supplierID");
					String supplierNumber = rs.getString("supplierNumber");
					String supplierName = rs.getString("supplierName");
					carNumber = rs.getString("carNumber");
//					String materialID = rs.getString("materialID");
//					String materialNumber = rs.getString("materialNumber");
//					String materialName = rs.getString("materialName");
					Date fbizdate = rs.getDate("fbizdate");
					int FBaseStatus = rs.getInt("FBaseStatus");
					BigDecimal baseQty = rs.getBigDecimal("baseQty");
					BigDecimal bagQty = rs.getBigDecimal("bagQty");
//					if(FBaseStatus < 4){
//						throw new BOSException("该订单尚未审核，请确认订单号录入是否准确。");
//					}
					orderInfo.setBizDate(fbizdate);
					orderInfo.setOrderID(billID);
					orderInfo.setOrderNumber(billNumber);
					orderInfo.setCarNumber(carNumber);
//					orderInfo.setMaterialID(materialID);
//					orderInfo.setMaterialName(materialName);
//					orderInfo.setMaterialNumber(materialNumber);
					orderInfo.setOrderBaseQty(baseQty);
					orderInfo.setBagQty(bagQty);
					orderInfo.setCusSuppID(supplierID);
					orderInfo.setCusSuppName(supplierName);
					orderInfo.setCusSuppNumber(supplierNumber);
					//orderInfo.setEntryID(rs.getString("entryID"));
					BillBaseStatusEnum baseStatus = BillBaseStatusEnum.getEnum(FBaseStatus);
					orderInfo.setBaseStatusEnum(baseStatus);
					resultMap.put(billID, orderInfo);//entryID
				}
			
		}catch(Exception sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return resultMap;
	}
    

	/**
	 * 更新采购过磅单源单据信息 
	 * 并保存日志到 过磅单更新记录中
	 * @throws EASBizException 
	 */
	@Override
	protected void _updateInweightSourceBillInfo(Context ctx,
			InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo,
			BigDecimal newGross,BigDecimal newTare)
			throws BOSException{
		// 校验过磅单是否存在下游单据，如果存在则 抛出异常
		if(AppCommon.existDestBill(ctx, billInfo.getBOSType().toString(), billInfo.getId().toString())){
			throw new BOSException("该过磅单已经存在下游单据，不能更新源单据");
		}
		
		// 供应商
		SupplierInfo supplierInfo = new SupplierInfo();
		supplierInfo.setId(BOSUuid.read(orderWeightInfo.getCusSuppID()));
		supplierInfo.setNumber(orderWeightInfo.getCusSuppNumber());
		supplierInfo.setName(orderWeightInfo.getCusSuppName());
		// 物料
		MaterialInfo materialInfo = new MaterialInfo();
		materialInfo.setId(BOSUuid.read(orderWeightInfo.getMaterialID()));
		materialInfo.setNumber(orderWeightInfo.getMaterialNumber());
		materialInfo.setName(orderWeightInfo.getMaterialName());
		
		// 只有一行分录才更新  多行分录  待定 TODO 
		if(billInfo != null && billInfo.getEntrys() != null && billInfo.getEntrys().size() == 1){
			try{
				// 保存更新日志 TODO
				StorageBillEditBillInfo editBillInfo = new StorageBillEditBillInfo();
				editBillInfo.setId(BOSUuid.create(editBillInfo.getBOSType().toString()));
				
				// 获取目标订单INFO
				PurOrderInfo purOrderInfo = PurOrderFactory.getLocalInstance(ctx).getPurOrderInfo(new ObjectUuidPK(orderWeightInfo.getOrderID()));
				if(purOrderInfo.getEntries().size() > 1){
					throw new BOSException("选择的名单分录超过一行，不符合过磅订单要求，请核对采购订单是否选错");
				}
				PurOrderEntryInfo orderEntryInfo = purOrderInfo.getEntries().get(0);
				orderEntryInfo = PurOrderEntryFactory.getLocalInstance(ctx).getPurOrderEntryInfo(new ObjectUuidPK(orderEntryInfo.getId()));
				
				// 更新原订单号
				if(StringUtils.isNotBlank(orderWeightInfo.getOrderNumber())){
					this.addEditEntryInfo(editBillInfo, FieldType.BillHeader, "采购订单号", billInfo.getPurOrderNumber(), orderWeightInfo.getOrderNumber(), null, null);
					billInfo.setPurOrderNumber(orderWeightInfo.getOrderNumber());
				}
				
				
				// 更新供应商
				String oldSupplierID = "";
				if(billInfo.getSupplier() != null){
					oldSupplierID = billInfo.getSupplier().getId().toString();
				}
				this.addEditEntryInfo(editBillInfo, FieldType.BillHeader, "供应商ID", oldSupplierID, orderWeightInfo.getCusSuppID(), null, null);
				billInfo.setSupplier(supplierInfo);
				
				// 更新车号
				String carNum = purOrderInfo.getString("carNumber");
				String oldCarNum = billInfo.getCarNum();
				this.addEditEntryInfo(editBillInfo, FieldType.BillHeader, "车牌号", oldCarNum, carNum, null, null);
				billInfo.setCarNum(carNum);
				
				
				
				// 分录更新
				InStorageBillEntryInfo entryInfo =  billInfo.getEntrys().get(0);
				if(entryInfo == null){
					throw new BOSException("过磅单明细行为空，请联系管理员处理");
				}else if(entryInfo.getMaterial() == null){
					entryInfo = InStorageBillEntryFactory.getLocalInstance(ctx).getInStorageBillEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					
					
				}
				// 更新物料名称
				String oldMaterialName = "";
				if(entryInfo.getMateiralName() != null){
					oldMaterialName = entryInfo.getMateiralName();
				}
				this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "物料名称", oldMaterialName, materialInfo.getName(), null, null);
				entryInfo.setMateiralName(materialInfo.getName());
				
				// 物料ID
				String materialID = "";
				if(entryInfo.getMaterial() != null){
					materialID = entryInfo.getMaterial().getId().toString();
				}
				this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "物料ID", materialID, materialInfo.getId().toString(), null, null);
				entryInfo.setMaterial(materialInfo);
				
				
//				// 分录计量单位
//				this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "分录计量单位", entryInfo.getUnit().getId().toString(), orderEntryInfo.getUnit().getId().toString(), null, null);
//				entryInfo.setUnit(orderEntryInfo.getUnit());
				// 更新 过磅重量
				BigDecimal gross = entryInfo.getGross();
				BigDecimal tare = entryInfo.getTare();
				BigDecimal suttle = entryInfo.getSuttle();
				if(newGross != null){
					
					this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "毛重", null, null, gross, newGross);
					entryInfo.setGross(newGross);
					gross = newGross;
				}
				
				if(newTare != null){
					this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "皮重", null, null, tare, newTare);
					entryInfo.setTare(newTare);
					tare = newTare;
				}
				// 更新净重
				if(gross != null && tare != null){
					BigDecimal oldSuttle = entryInfo.getSuttle();
					suttle = gross.subtract(tare);
					this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "净重", null, null, oldSuttle, suttle);
					
					entryInfo.setSuttle(suttle);
				}
				
				
				
//				// 分录计量单位
//				this.addEditEntryInfo(editBillInfo, FieldType.BillEntry, "分录计量单位", entryInfo.getUnit().getId().toString(), orderEntryInfo.getUnit().getId().toString(), null, null);
//				entryInfo.setUnit(orderEntryInfo.getUnit());
//				if(billInfo.getBillStatus())
				
				
				// 更新单据
				InStorageBillFactory.getLocalInstance(ctx).save(billInfo);
				
				// 日志
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				editBillInfo.setNumber(sdf.format(new Date()));
				editBillInfo.setBillID(billInfo.getId().toString());
				editBillInfo.setBizDate(new Date());
				editBillInfo.setStorageBillType(StorageBillType.Instorage);
				editBillInfo.setStorageBillNumber(billInfo.getNumber());
				editBillInfo.setDescription("手工更新来源订单");
				
				// 新增日志
				StorageBillEditBillFactory.getLocalInstance(ctx).addnew(editBillInfo);
				// 更新 过磅单与采购订单关联关系
				String upsql = "update t_bot_relation set fsrcobjectid =? where fdestobjectid=? and fsrcentityid=? and fdestentityid=?";
				Object[] args = {orderWeightInfo.getOrderID(),billInfo.getId().toString(),"3171BFAD",billInfo.getBOSType().toString()};
				DbUtil.execute(ctx, upsql, args);
				
			}catch(EASBizException bize){
				bize.printStackTrace();
				throw new BOSException(bize);
			}
		}
		
		
	}
	
	

	@Override
	protected Map _getQCInfoByNumber(Context ctx, String number,
			String carNumbers, String beginDate, String endDate)
			throws BOSException {
		Map<String,OrderWeightInfo> resultMap = new LinkedHashMap<String,OrderWeightInfo>();
		
		
		try{
			
				StringBuilder sql = new StringBuilder();
				sql.append("select t.fid billID,t.fnumber billNumber,t.fbizdate,ts.FName_l2 supplierName,ts.FID supplierID,ts.FNumber supplierNumber,tm.fid materialid,tm.FNumber materialnumber,tm.FName_l2 materialname,");
				sql.append(" t.CFtruckNumber carNumber,abs(sum(te.CFDeductWgt)) CFDeductWgt ");
				//sql.append(" ");
				sql.append(" from CT_FM_QualityCheckBill t ");
				sql.append(" inner join CT_FM_QualityCheckBillEntry te on te.FParentID = t.fid  ");
				sql.append(" inner join t_bd_supplier ts on t.CFSupplierID = ts.fid ");
				sql.append(" inner join T_BD_Material tm on tm.FID = t.CFMaterialID ");
				sql.append(" where  t.CFBaseStatus = 4   and t.CFIsWeight !=1  or t.CFIsWeight is null ");
				//sql.append(" and t.FCompanyID='").append(ContextUtil.getCurrentFIUnit(ctx).getString("id")).append("'");
				if(StringUtils.isNotBlank(number)){
					sql.append(" and  t.fnumber like '%");
					sql.append(number);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(carNumbers)){
					sql.append(" and  t.CFtruckNumber like '%");
					sql.append(carNumbers);
					sql.append("%' ");
				}
				if(StringUtils.isNotBlank(beginDate)){
					sql.append(" and  t.fbizdate >= { ts'");
					sql.append(beginDate);
					sql.append("'} ");
				}
				if(StringUtils.isNotBlank(endDate)){
					sql.append(" and  t.fbizdate <= { ts'");
					sql.append(endDate);
					sql.append(" 23:59:59'} ");
				}
				sql.append("group by  t.fid,t.fnumber,t.fbizdate,ts.FName_l2,ts.FID,ts.FNumber,tm.fid,t.CFtruckNumber,tm.FName_l2,tm.FNumber");
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				if(rs.size() < 1){
					throw new BOSException("未查询到的相应质检单，请检查输入是否正确");
				}
//				if(rs.size() > 1){
//					throw new BOSException("该订单存在多条分录，不能进行采购过磅，请检查订单号是否输入正确");
//				}
				// 取数
				while(rs.next()){
					OrderWeightInfo orderInfo = new OrderWeightInfo();
					String billID = rs.getString("billID");
					//String entryID= rs.getString("entryID");
					String billNumber = rs.getString("billNumber");
					String supplierID = rs.getString("supplierID");
					String supplierNumber = rs.getString("supplierNumber");
					String supplierName = rs.getString("supplierName");
					String carNumber = rs.getString("carNumber");
					//String carId = rs.getString("carid");
					String materialID = rs.getString("materialid");
					String materialNumber = rs.getString("materialnumber");
					String materialName = rs.getString("materialname");
					Date fbizdate = rs.getDate("fbizdate");
					//int FBaseStatus = rs.getInt("FBaseStatus");
					BigDecimal baseQty = rs.getBigDecimal("CFDeductWgt");
//					if(FBaseStatus < 4){
//						throw new BOSException("该订单尚未审核，请确认订单号录入是否准确。");
//					}
					orderInfo.setBizDate(fbizdate);
					orderInfo.setOrderID(billID);
					orderInfo.setOrderNumber(billNumber);
					orderInfo.setCarNumber(carNumber);
					orderInfo.setMaterialID(materialID);
					orderInfo.setMaterialName(materialName);
					orderInfo.setMaterialNumber(materialNumber);
					orderInfo.setOrderBaseQty(baseQty);
					orderInfo.setCusSuppID(supplierID);
					orderInfo.setCusSuppName(supplierName);
					orderInfo.setCusSuppNumber(supplierNumber);
					//orderInfo.setCarId(carId);
					//orderInfo.setEntryID(rs.getString("entryID")); 
					//BillBaseStatusEnum baseStatus = BillBaseStatusEnum.getEnum(FBaseStatus);
					//orderInfo.setBaseStatusEnum(baseStatus);
					resultMap.put(billID, orderInfo);//billID
				}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return resultMap;
		// TODO Auto-generated method stub
		
	}

	/**
	 * 单据添加分录
	 * @param editBillInfo
	 * @param fieldType
	 * @param fieldName
	 * @param oldID
	 * @param newID
	 * @param oldValue
	 * @param newValue
	 * @return
	 */
	private void addEditEntryInfo(StorageBillEditBillInfo editBillInfo,
			FieldType fieldType,
			String fieldName,
			String oldID,
			String newID,
			BigDecimal oldValue,
			BigDecimal newValue){
		
		StorageBillEditBillEntryInfo editEntryInfo = new StorageBillEditBillEntryInfo();
//		if(editBillInfo.getEntrys() == null){
//			StorageBillEditBillEntryCollection entryColl = new StorageBillEditBillEntryCollection();
//			editBillInfo
//		}
		editEntryInfo.setParent(editBillInfo);
		editEntryInfo.setFieldType(fieldType);
		editEntryInfo.setFieldName(fieldName);
		editEntryInfo.setOldID(oldID);
		editEntryInfo.setNewID(newID);
		editEntryInfo.setOldValue(oldValue);
		editEntryInfo.setNewValue(newValue);
		
		editBillInfo.getEntrys().add(editEntryInfo);
	}
    
    
    
}