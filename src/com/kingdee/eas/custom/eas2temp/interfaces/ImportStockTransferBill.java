package com.kingdee.eas.custom.eas2temp.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.StorageOrgUnit;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.service.OrgCommonUtils;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.basedata.scm.im.inv.StoreTypeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.custom.eas2temp.comm.TempUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsEntryInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillEntryInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillFactory;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.util.app.ContextUtil;



public class ImportStockTransferBill implements IImport2EAS {
	private HashMap<String, ArrayList<Integer>> idListMap;
	/**
	 * 导入库存调拨单
	 */
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {

		Connection conn = null;
		String msg = "";

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);// 获得连接
			if (conn == null) {
				throw new Exception("请设置连接参数正确！");
			}
			Date nowDate = null;
			Date nextDate = null;

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// 开始日期结束日期都为空，为服务器端调用
				nowDate = new java.util.Date();
				nextDate = EASWUtils.getNextDay(nowDate);
			} else {
				nowDate = f.parse(beginDate);
				nextDate = f.parse(endDate);
				nextDate = EASWUtils.getNextDay(nextDate);
			}
			setIDListMap(conn, f.format(nowDate), f.format(nextDate));// fID和easbillnumber
			PreparedStatement ptm = conn.prepareStatement(getQueryStr(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ptm.setDate(1, new java.sql.Date(nowDate.getTime()));
			ptm.setDate(2, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = ptm.executeQuery();

			ArrayList<Integer> tempBillNumList = new ArrayList<Integer>();// 保存tempnumber
			StockTransferBillInfo info = null;
			String billNum = null, billNumKeep = null;
			String billType="库存调拨单";
			rs.last();
			int count = rs.getRow();// 最大行数
			rs.beforeFirst();
			while (rs.next()) {
				int barBillID=rs.getInt("FID");
				billType=billType+rs.getString("FType");
				if(EASWUtils.checkHasImported(ctx, barBillID, billType)){
					continue;
				}
				billNum = rs.getString("FERPBillNo");
				if (rs.getRow() == 1||StringUtils.isBlank(billNumKeep)) {
					billNumKeep = billNum;
				}

				// 这里对上个创建的info进行保存操作
				if (!billNumKeep.equals(billNum)) {// billnumKeep！=billnum
					exeImportSave(ctx, info, tempBillNumList,billType);
					tempBillNumList.clear();
					billNumKeep = billNum;
					info = null;
				}

				// 在这里创建info，设置info各种信息
				if (!tempBillNumList.contains(barBillID)) {// tempBillNumList不含billnum
					tempBillNumList.add(barBillID);
					try {
						info = exeImportAction(ctx, companyID, info, rs);// 执行插入
					} catch (Exception e) {
						info = null;
					}
				}

				// 这里处理最后一条信息
				if (rs.getRow() == count) {
					exeImportSave(ctx, info, tempBillNumList,billType);
					tempBillNumList.clear();
					billNumKeep = billNum;
					info = null;
				}
			}

			rs.close();
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
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
	private void exeImportSave(Context ctx, StockTransferBillInfo info, ArrayList<Integer> tempBillNumList,
			String billType) throws BOSException, EASBizException {

		if (info != null) {
			IObjectPK pk = null;
			Boolean isSuccess = true;
			String msg = null;
			try {// 添加新的采购入库单，反写出错则要删除单据
				pk = StockTransferBillFactory.getLocalInstance(ctx).addnew(info);
				//EASWUtils.insertHasImported(ctx, tempBillNumList, billType);
			} catch (Exception e) {
				isSuccess = false;
				msg = e.getMessage();
				if (pk != null) {
					StockTransferBillFactory.getLocalInstance(ctx).delete(pk);
				}
			} finally {
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
	}

	private StockTransferBillInfo exeImportAction(Context ctx, String companyID, StockTransferBillInfo info, ResultSet rs) throws EASBizException, BOSException, SQLException {

		// 设置单据头
		if (info == null) {
			info = new StockTransferBillInfo();
			String number = "";
			// 获得新的number
			if (ctx != null) {
				number = StockTransferBillFactory.getLocalInstance(ctx).getNewNumber(info, companyID, null);
			} else {
				number = StockTransferBillFactory.getRemoteInstance().getNewNumber(info, companyID, null);
			}
			info.setNumber(number);
			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setBizDate(rs.getDate("FDate"));
			info.setBillType(BillTypeFactory.getLocalInstance(ctx).getBillTypeInfo(
					new ObjectUuidPK("50957179-0105-1000-e003-3152c0a812fd463ED552")));
			info.setBizType(BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(
							new ObjectUuidPK("d8e80652-011b-1000-e000-04c5c0a812202407435C")));// 业务类型
			info.setCU((CtrlUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, companyID, OrgType.ControlUnit, null));
			StorageOrgUnitInfo storageOrgUnitInfo=ContextUtil.getCurrentStorageUnit(ctx);
			info.setIssueStorageOrgUnit(storageOrgUnitInfo);//调出库存组织，默认玛斯特
			info.setReceiptStorageOrgUnit(storageOrgUnitInfo);//调入库存组织，默认玛斯特
//			info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(
//			new ObjectUuidPK("1aa51711-0f60-455a-a3c2-43b86155098dB008DCA7")));// 事务类型


		}
		// 设置分录
		StockTransferBillEntryInfo entryInfo = new StockTransferBillEntryInfo();
		String materialNum;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		MaterialCollection mColl;
		MaterialInfo mInfo = null;
		EntityViewInfo ev;
		FilterInfo filter;
		// 物料编码对应转换
		materialNum = EASWUtils.getEASMaterialNumber(ctx, rs.getString("FMaterialNum"));// 物料编码
		ev = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number", materialNum, CompareType.EQUALS));
		ev.setFilter(filter);
		mColl = ims.getMaterialCollection(ev);// 根据物料编码获取物料
		if (mColl != null && mColl.size() > 0) {
			SelectorItemCollection slr = new SelectorItemCollection();
			slr.add(new SelectorItemInfo("*"));
			mInfo = ims.getMaterialInfo(new ObjectUuidPK(mColl.get(0).getString("id")),slr);// 物料
			entryInfo.setMaterial(mInfo);
			entryInfo.setBaseUnit(mInfo.getBaseUnit());
			entryInfo.setUnit(mInfo.getBaseUnit());
			String storageOrgUnitID=null;
			if(ContextUtil.getCurrentStorageUnit(ctx).getId().toString()!=null){
				storageOrgUnitID=ContextUtil.getCurrentStorageUnit(ctx).getId().toString();
			}
			entryInfo.setIssueWarehouse(EASWUtils.getDefaultYLWareHouse(ctx, storageOrgUnitID));//调出仓库为原料默认仓库
			entryInfo.setReceiptWarehouse(EASWUtils.getDefaultLLWareHouse(ctx, storageOrgUnitID));//调入仓库为领料默认仓库
			entryInfo.setQty(rs.getBigDecimal("FQty"));
			entryInfo.setBaseQty(entryInfo.getQty());
			entryInfo.setString("model", mInfo.getModel());
			entryInfo.setIssuePlanDate(info.getBizDate());
			entryInfo.setReceiptPlanDate(info.getBizDate());
			entryInfo.setStoreType(StoreTypeFactory.getLocalInstance(ctx).getStoreTypeInfo(new ObjectUuidPK("181875d5-0105-1000-e000-0111c0a812fd97D461A6")));
			

			info.getEntry().add(entryInfo);// 将此条分录插入到单据体中
		} else {
			return null;
		}

		return info;
	
	}

	/**
	 * 设置ID
	 * 
	 * @param conn
	 * @param beginDate
	 * @param endDate
	 * @throws SQLException
	 */
	private void setIDListMap(Connection conn, String beginDate, String endDate) throws SQLException {
		this.idListMap = new HashMap<String, ArrayList<Integer>>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select *  ");// eas调拨入库单no   
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and FDate>='").append(beginDate).append("'");
		sql.append(" and FDate<='").append(endDate).append("'");
		sql.append(" order by FERPBillNo,FID");
		ResultSet rs = conn.createStatement().executeQuery(sql.toString());
		String stocktransferID = null, stocktransferIDKeep = null;

		ArrayList<Integer> list = new ArrayList<Integer>();
		while (rs.next()) {
			stocktransferID = rs.getString("FERPBillNo");
			if (rs.getRow() == 1) {
				// 第一行
				stocktransferIDKeep = stocktransferID;
			}
			if (!stocktransferIDKeep.equals(stocktransferID)) {
				idListMap.put(stocktransferIDKeep, (ArrayList<Integer>) list.clone());
				stocktransferIDKeep = stocktransferID;
				list.clear();
			}
			// list中加入id
			list.add(rs.getInt("FID"));
		}
		idListMap.put(stocktransferID, list);
		rs.close();
	}
	public String getEASBosType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEASSourceBosType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQueryStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT *");//  FType,FID,FDate,FERPBillNo,FMaterialNum,FQty,FBatchNum
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and FDate>=?");
		sql.append(" and FDate<=?");
		sql.append(" order by FERPBillNo,FID");
		return sql.toString();
	}

	public String getSourceBillID(Context ctx, String orgUnitID, String TempSourceBillNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "v_materialTrans";
	}

	public String getTempSourceTable() {
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
