package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.assistant.PaymentTypeFactory;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
//import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.im.inv.IPurInWarehsBill;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsEntryInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.portal.biz.common.exception.BizException;
import com.kingdee.util.NumericExceptionSubItem;

public class ImportPurInwarehouseBill implements IImport2EAS {
	/**
	 * 通过botp导入采购入库单
	 */
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {

		Connection conn = null;

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);// 得到连接
			if (conn == null) {
				throw new Exception("请确认连接参数设置正确!");
			}
//			Date nowDate = new java.util.Date();
//			Date nextDate = EASWUtils.getNextDay(nowDate);
			
			PreparedStatement ptm = conn.prepareStatement(getQueryStr(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			//设定时间测试
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(beginDate + " 00:00:00");
			Date date3 = sdf.parse(endDate + " 00:00:00");
			Calendar c=Calendar.getInstance();
			c.setTime(date3);
			c.add(Calendar.DATE, 1);
			Date date2=c.getTime();
			
			ptm.setDate(1, new java.sql.Date(date.getTime()));
			ptm.setDate(2, new java.sql.Date( date2.getTime()));
			ResultSet rs = ptm.executeQuery();

			ArrayList<Integer> tempBillIDList = new ArrayList<Integer>();
			HashSet<String> sourceBillIDs = new HashSet<String>();// 关联采购订单的id
			HashMap<String, BigDecimal> qtyMap = new HashMap<String, BigDecimal>();// 数量
			String billNum = null, billNumKeep = null;// temp单据编码
			String materialNum;// 物料编码
			String billType="采购入库单";
			BigDecimal qty = BigDecimal.ZERO;// 同一物料的累计数量
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				int barBillID=rs.getInt("ID");
				
				
				//如果采购订单号为空，就跳过
				
				if(rs.getString("po")==null){
					LogBean logBean=new LogBean();
					logBean.setBosType("783061E3");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("采购订单号为空的数据未导入");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(barBillID));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}
				billNum = rs.getString("po").trim().replace(" ", "");// 条码系统中保存的eas采购订单编码,去掉前后空格去掉中间空格
				if (rs.getRow() == 1||StringUtils.isBlank(billNumKeep)) {
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx,ContextUtil.getCurrentCtrlUnit(ctx).getString("id"),billNum));// eas采购订单id
				}
				if(EASWUtils.checkHasImported(ctx, barBillID,billType)&&billNum.equals(billNumKeep)){
					qtyMap.clear();
					continue;
				}
				// 使用botp进行导入
				if (rs.getRow() <= count && !billNumKeep.equals(billNum)) {
					System.out.println("different number");
					if(!qtyMap.isEmpty()&&! "".equals(sourceBillIDs.iterator().next())){
						exeImportByBotp(ctx, conn, sourceBillIDs, qtyMap, tempBillIDList);
						//EASWUtils.insertHasImported(ctx, tempBillIDList,billType);
					}
					
					
					tempBillIDList.clear();
					sourceBillIDs.clear();
					qtyMap.clear();
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx,ContextUtil.getCurrentCtrlUnit(ctx).getString("id"),billNum));// eas采购订单number
				}
						
				String	barmaterialNum = rs.getString("Ylid");// 获取物料num
				
				//此处 物料转换   ，若不存在则跳过并插入日志
				materialNum=EASWUtils.getEASMaterialNumber(ctx, barmaterialNum);
				if(materialNum==""){
					LogBean logBean=new LogBean();
					logBean.setBosType("783061E3");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("不存在条码物料编码为："+barmaterialNum+" 的对应关系");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(barBillID));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}
				qty = rs.getBigDecimal("RZL");// 获取数量
				if (qty == null) {
					qty = BigDecimal.ZERO;
				}
				if (!qtyMap.containsKey(materialNum)) {// 物料和数量对应,如果不存在则新添加一个，如果存在则数量累加
					qtyMap.put(materialNum, qty);
				} else {
					qty = qty.add(qtyMap.get(materialNum));
					qtyMap.put(materialNum, qty);
				}
				tempBillIDList.add(barBillID);

				// 最后一条记录直接执行botp
				if (rs.getRow() == count&&!qtyMap.isEmpty()&&! "".equals(sourceBillIDs.iterator().next())) {
					exeImportByBotp(ctx, conn, sourceBillIDs, qtyMap, tempBillIDList);
					//EASWUtils.insertHasImported(ctx, tempBillIDList,billType);
				}
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

	/**
	 * 执行单据转换
	 * 
	 * @param ctx
	 * @throws ClassNotFoundException
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws SQLException
	 */
	private void exeImportByBotp(Context ctx, Connection conn, HashSet<String> sourceBillIDs, HashMap<String, BigDecimal> qtyMap,
			ArrayList<Integer> tempBillIDList) throws BOSException, ClassNotFoundException, EASBizException, SQLException {

		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		String msg=null;
		Boolean isSuccess=true;
		String sourceBillID = null;
		if (sourceBillIDs.iterator().hasNext()) {
			 sourceBillID = sourceBillIDs.iterator().next();
		}
		
		
		filter.getFilterItems().add(new FilterItemInfo("id", sourceBillID, CompareType.INCLUDE));
		ev.setFilter(filter);
		CoreBillBaseCollection col = EASWUtils.getIInstance(ctx, getEASSourceBosType()).getCoreBillBaseCollection(ev);
		IPurInWarehsBill ips = PurInWarehsBillFactory.getLocalInstance(ctx);
					
		//****************
		PurInWarehsBillInfo info=null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		btp = BTPManagerFactory.getLocalInstance(ctx);
		result = btp.transform(col, getEASBosType());
		info = (PurInWarehsBillInfo) result.getBills().getObject(0);
		//*******************
		
		if (info==null) {
			return;
		}
		HashMap<String, BigDecimal> purOrderQtyMap=new HashMap<String, BigDecimal>();
		getPurOrderQtyMap(ctx,sourceBillID,purOrderQtyMap);
		String id=info.getString("id");
		//设置单据体
		
		// 事务类型：普通采购/委外入库
		info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("DawAAAAPoACwCNyn")));
		//设置成本中心--根据库存组织获取默认成本中心
		info.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));
//		info.setPaymentType(PaymentTypeFactory.getLocalInstance(ctx).getPaymentTypeInfo(new ObjectUuidPK("")));
		//分录设置
		PurInWarehsEntryInfo entryInfo;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		//删除没有物料的采购入库单分录
		for (int index = 0; index < info.getEntry().size();) {
			if(index>=info.getEntry().size()) {//超出分录总行数
				break;
			}
			entryInfo = info.getEntry().get(index);
			if(!qtyMap.containsKey(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber())) {//导入的记录中不含有采购入库单分录的物料
				info.getEntry().removeObject(index);
				continue;
			}
			index++;
		}
		//设置采购入库单分录字段值
		for (int index = 0; index < info.getEntry().size(); index++) {
			entryInfo = info.getEntry().get(index);
			entryInfo.setQty(qtyMap.get(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
			entryInfo.setPrice(entryInfo.getTaxPrice().divide(BigDecimal.ONE.add(entryInfo.getTaxRate()),4,BigDecimal.ROUND_HALF_UP));//单价
			entryInfo.setUnitActualCost(entryInfo.getPrice());//单位实际成本
			entryInfo.setUnitPurchaseCost(entryInfo.getPrice());//单位实际成本
			entryInfo.setTaxAmount(entryInfo.getTaxPrice().multiply(entryInfo.getQty()));//价税合计
			entryInfo.setLocalTaxAmount(entryInfo.getTaxAmount());//价税合计本位币
			entryInfo.setAmount(entryInfo.getPrice().multiply(entryInfo.getQty()));//金额
			entryInfo.setActualCost(entryInfo.getAmount());//实际成本
			entryInfo.setPurchaseCost(entryInfo.getAmount());//采购成本
			entryInfo.setTax(entryInfo.getActualCost().multiply(entryInfo.getTaxRate()));//税额
			entryInfo.setLocalTax(entryInfo.getTax());//税额本位币
			entryInfo.setActualTaxPrice(entryInfo.getTaxPrice());//实际含税单价
			//仓库
			WarehouseInfo defaultWarehouse=EASWUtils.getDefaultByMaterial(ctx, ContextUtil.getCurrentStorageUnit(ctx).getId().toString(), entryInfo.getMaterial().getId().toString());
			if(defaultWarehouse==null){//如果物料默认仓库为空，则取设置的默认原料库
				defaultWarehouse=EASWUtils.getDefaultYLWareHouse(ctx,  ContextUtil.getCurrentStorageUnit(ctx).getId().toString());
			}
			entryInfo.setWarehouse(defaultWarehouse);
			entryInfo.setBigDecimal("purOrderQty", purOrderQtyMap.get(entryInfo.getMaterial().getId().toString()).setScale(4));
			//设置更新类型--普通入库2016-03-05新增
			//****add @20160305
			  TransactionTypeInfo transactionType = info.getTransactionType();
//			  InvUpdateTypeInfo invUpdateTypeInfo = null;
//			  try {
//				  invUpdateTypeInfo = TransactionTypeFactory.getLocalInstance(ctx).getDefaultInvUpdateType(transactionType.getId().toString());
//			  }
//			  catch (Exception e)
//			  {
//			  }
//			  entryInfo.setInvUpdateType(invUpdateTypeInfo);//更新类型 add@20160305
			  //*****
		
		}
		IObjectPK pk = null;
		try {
			pk = ips.save(info);//保存采购入库单
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e) {
			isSuccess=false;
			msg=e.getMessage();
			if (pk != null) {// 反写失败需要删除
				PurInWarehsBillFactory.getLocalInstance(ctx).delete(pk);
			}
			throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
		}finally{
			LogBean logBean = new LogBean();
			logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
			logBean.setBosType(info.getBOSType().toString());
			logBean.setEasBillID(info.getId().toString());
			logBean.setDirection(LogBean.Direction_Import);
			logBean.setSuccess(isSuccess);
			logBean.setMsg(msg);
			EASWUtils.insertLogs(ctx, logBean);// 插入日志
		}
	}



	private void getPurOrderQtyMap(Context  ctx,String sourceBillID,
			HashMap<String, BigDecimal> purOrderQtyMap) throws BOSException, EASBizException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select FMaterialID,fqty from T_SM_PurOrderEntry");
		sql.append(" where FParentID='").append(sourceBillID).append("'");
		sql.append("");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				purOrderQtyMap.put(rs.getString("FMaterialID"), rs.getBigDecimal("fqty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001","sql查询失败"));
		}
	}

	/**
	 * 获得中间库中采购入库单的单据头table
	 */
	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "v_EnterStock";
	}

	public String getEASBosType() {
		//采购入库的BosType
		return "783061E3"; 
	}

	public String getEASSourceBosType() {
		//采购订单BosType
		return "3171BFAD";
		
	}

	/**
	 * 获得要导入的数据
	 */
	public String getQueryStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT *");
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and RDate>=?");
		sql.append(" and RDate<?");
		sql.append(" order by po,id");

		return sql.toString();
	}

	
	/**
	 * 得到 来源eas id
	 */
	public String getSourceBillID(Context ctx, String orgUnitID,String TempSourceBillNum) {
		String result = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid from ").append(getTempSourceTable());
		sql.append(" where fnumber='").append(TempSourceBillNum).append("'");
		sql.append(" and FControlUnitID='").append(orgUnitID).append("'");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				result = rs.getString("fid");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new EASBizException(new NumericExceptionSubItem("001","查询不到采购订单编码为："+TempSourceBillNum));
			} catch (EASBizException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

	public String getTempSourceTable() {
		return "T_SM_PurOrder";
	}


	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String importBillByBotp(Context ctx, String companyID,
			String beginDate, String endDate, String string)
			throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

}
