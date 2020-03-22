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
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
//import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.scm.im.inv.IManufactureRecBill;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillEntryInfo;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillFactory;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class ImportProductInBill implements IImport2EAS {

	/**
	 * 通过botp导入生产入库单
	 */
	public String importBillByBotp(Context ctx, String companyID,
			String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					TargetSystem.BARSYSTEM_VALUE);// 得到连接
			if (conn == null) {
				throw new Exception("请确认连接参数设置正确");
			}

			PreparedStatement ptm = conn.prepareStatement(getQueryStr(),
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			//设定时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(beginDate + " 00:00:00");
			Date date3 = sdf.parse(endDate + " 00:00:00");
			Calendar c=Calendar.getInstance();
			c.setTime(date3);
			c.add(Calendar.DATE, 1);
			Date date2=c.getTime();

			ptm.setDate(1, new java.sql.Date(date.getTime()));
			ptm.setDate(2, new java.sql.Date(date2.getTime()));
			ResultSet rs = ptm.executeQuery();

			ArrayList<Integer> tempBillIDList = new ArrayList<Integer>();
			HashSet<String> sourceBillIDs = new HashSet<String>();// 关联生产订单的id
			HashMap<String, BigDecimal> qtyMap = new HashMap<String, BigDecimal>();// 数量
			String billNum = null, billNumKeep = null;// temp单据编码
			String materialNum;// 物料编码
			String billType = "生产入库单";
			BigDecimal qty = BigDecimal.ZERO;// 同一物料的累计数量
			rs.last();
			boolean lasthasimported=false;
			int count = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				int barBillID = rs.getInt("ID");// 成品入库单id
				if (EASWUtils.checkHasImported(ctx, barBillID, billType)) {
					if(rs.getRow()==count){//最后一条数据已经导入了，最后不需要再执行一遍
						lasthasimported=true;
					}else{
						continue;
					}
				}
				billNum = rs.getString("erpBillNo");// 生产订单编码
				if (StringUtils.isBlank(billNum)) {
					continue;
				}
				if (rs.getRow() == 1 || StringUtils.isBlank(billNumKeep)) {
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx, ContextUtil
							.getCurrentCtrlUnit(ctx).getString("id"), billNum));// eas采购订单id
				}
				// 使用botp进行导入，使用<=是因为若最后一条数据和倒数第二条不同，则导入最后一条数据前先导入前面的数据
				if (rs.getRow() <= count && !billNumKeep.equals(billNum)) {
					System.out.println("different number");
					//qty not null then import
					if(!qtyMap.isEmpty()&&! "".equals(sourceBillIDs.iterator().next())){
						exeImportByBotp(ctx, conn, sourceBillIDs, qtyMap,
								tempBillIDList);
						//EASWUtils.insertHasImported(ctx, tempBillIDList, billType);
					}

					tempBillIDList.clear();
					sourceBillIDs.clear();
					qtyMap.clear();
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx, ContextUtil
							.getCurrentCtrlUnit(ctx).getString("id"), billNum));// eas源单据number
				}
				String barmaterialNum = rs.getString("CPID");// 条码成品物料编码
				// 此处 物料转换 ，若不存在则跳过并插入日志
				materialNum = EASWUtils.getEASMaterialNumber(ctx,
						barmaterialNum);
				if (materialNum == "") {
					LogBean logBean = new LogBean();
					logBean.setBosType("");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("不存在条码物料编码为：" + barmaterialNum + " 的对应关系");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
							.getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(rs.getInt("ID")));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}

				qty = rs.getBigDecimal("RSL");// 入库数量
				if (qty == null) {
					qty = BigDecimal.ZERO;
				}
				if (!qtyMap.containsKey(materialNum)) {// 物料和数量对应,如果不存在则新添加一个，
					// 如果存在则数量累加
					qtyMap.put(materialNum, qty);
				} else {
					qty = qty.add(qtyMap.get(materialNum));
					qtyMap.put(materialNum, qty);
				}
				tempBillIDList.add(barBillID);
				// 最后一条记录直接执行botp
				if (rs.getRow() == count&&!qtyMap.isEmpty()&&!lasthasimported&&! "".equals(sourceBillIDs.iterator().next())) {
					exeImportByBotp(ctx, conn, sourceBillIDs, qtyMap,
							tempBillIDList);
					//EASWUtils.insertHasImported(ctx, tempBillIDList, billType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001", e
					.getMessage()));
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
	private void exeImportByBotp(Context ctx, Connection conn,
			HashSet<String> sourceBillIDs, HashMap<String, BigDecimal> qtyMap,
			ArrayList<Integer> tempBillNumList) throws BOSException,
			ClassNotFoundException, EASBizException, SQLException {

		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		String msg = null;
		Boolean isSuccess = true;
		String sourceBillID = null;
		if (sourceBillIDs.iterator().hasNext()) {
			sourceBillID = sourceBillIDs.iterator().next();
		}
		filter.getFilterItems().add(
				new FilterItemInfo("id", sourceBillIDs, CompareType.INCLUDE));// 源单据id
		ev.setFilter(filter);
		CoreBillBaseCollection col = EASWUtils.getIInstance(ctx,
				getEASSourceBosType()).getCoreBillBaseCollection(ev);
		IManufactureRecBill ips = ManufactureRecBillFactory
				.getLocalInstance(ctx);

		// ****************
		ManufactureRecBillInfo info = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		btp = BTPManagerFactory.getLocalInstance(ctx);
		result = btp.transform(col, getEASBosType());
		info = (ManufactureRecBillInfo) result.getBills().getObject(0);
		// *******************

		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		IManufactureOrder imf = ManufactureOrderFactory.getLocalInstance(ctx);// 成本对象为生产订单上的成本对象
		SelectorItemCollection slr = new SelectorItemCollection();
		slr.add("*");
		slr.add(new SelectorItemInfo("costObject.*"));
		ManufactureOrderInfo mfoinfo = imf.getManufactureOrderInfo(
				new ObjectUuidPK(sourceBillID), slr);

		// 生产关联单据
		if (info == null) {
			return;
		}
		String id = info.getString("id");

		// 设置单据体
		info.setDescription("");// 备注
		info.setBillType(BillTypeFactory.getLocalInstance(ctx).getBillTypeInfo(new ObjectUuidPK("50957179-0105-1000-e000-0167c0a812fd463ED552")));
		info.setBizType(BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("Nz878AEgEADgAABFwKg/GiQHQ1w=")));//业务类型 普通生产入库
		//事务类型根据botp自动设置
//		info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("DawAAAAPoCqwCNyn")));// 事务类型 完工合格入库

		info.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(
				ctx, info.getStorageOrgUnit().getId().toString()));// 设置成本中心--
																	// 根据库存组织获取默认成本中心

		// 分录设置
		ManufactureRecBillEntryInfo entryInfo;

		// 删除没有物料的生产入库单分录
		for (int index = 0; index < info.getEntry().size();) {
			if (index > info.getEntry().size()) {// 超出分录总行数
				break;
			}
			entryInfo = info.getEntry().get(index);
			if (!qtyMap.containsKey(ims
					.getMaterialInfo(
							new ObjectUuidPK(entryInfo.getMaterial().getId()
									.toString())).getNumber())) {
				info.getEntry().removeObject(index);
				continue;
			}
			index++;
		}
		// 设置生产入库单分录字段值
		for (int index = 0; index < info.getEntry().size(); index++) {
			entryInfo = info.getEntry().get(index);
			entryInfo.setQty(qtyMap.get(entryInfo.getMaterial().getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
			WarehouseInfo warehouse = EASWUtils.getDefaultByMaterial(ctx,ContextUtil.getCurrentOrgUnit(ctx).getId().toString(),entryInfo.getMaterial().getId().toString());
			if (warehouse == null) {// 如果物料默认仓库为空，就去成品默认仓库
				warehouse = EASWUtils.getDefaultCPWareHouse(ctx, ContextUtil.getCurrentOrgUnit(ctx).getId().toString());
			}
			//设置物料默认仓库
			entryInfo.setWarehouse(warehouse);
			//设置成本对象
			entryInfo.setCostObject(mfoinfo.getCostObject());
			//设置成本中心
			entryInfo.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));//设置成本中心-- 根据库存组织获取默认成本中心
			
			//设置更新类型--普通入库2016-03-05新增
			//****add @20160305
			  TransactionTypeInfo transactionType = info.getTransactionType();
			  //InvUpdateTypeInfo invUpdateTypeInfo = null;
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
			pk = ips.save(info);
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e) {
			msg = e.getMessage();
			isSuccess = false;
			if (pk != null) {// 反写失败需要删除
				PurInWarehsBillFactory.getLocalInstance(ctx).delete(pk);
			}
			throw new EASBizException(new NumericExceptionSubItem("001", e
					.getMessage()));
		} finally {
			LogBean logBean = new LogBean();
			logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId()
					.toString());
			logBean.setBosType(info.getBOSType().toString());
			logBean.setEasBillID(info.getId().toString());
			logBean.setDirection(LogBean.Direction_Import);
			logBean.setSuccess(isSuccess);
			logBean.setMsg(msg);
			EASWUtils.insertLogs(ctx, logBean);// 插入日志

		}

	}

	/**
	 * 生产入库单分录表
	 */
	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return "cprk_productIn";
	}

	/**
	 * 生产入库单单据体表
	 */
	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "v_EnterStockCP";
	}

	public String getEASBosType() {
		// 生产入库单BosType
		return "FA1292B4";
	}

	public String getEASSourceBosType() {
		// 生产订单BosType
		return "1D0D80DD";
	}

	public String getQueryStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");// ID,CPID,PBBH,LOT,RDate,RSL,RNO,bz,erpBillNo
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and RDate>=?");// 入库日期
		sql.append(" and RDate<=?");// CreationDate
		sql.append(" order by CPID,ID");// 通过物料编码和billid来排序
		return sql.toString();
	}

	/**
	 * 得到来源 EAS 单据id
	 */
	public String getSourceBillID(Context ctx, String orgUnitID,
			String tempSourceBillNum) {
		String result = null;
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

	@Override
	public String importBillByBotp(Context ctx, String companyID,
			String beginDate, String endDate, String string)
			throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

}
