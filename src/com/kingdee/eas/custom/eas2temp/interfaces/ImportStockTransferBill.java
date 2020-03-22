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
	 * �����������
	 */
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {

		Connection conn = null;
		String msg = "";

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);// �������
			if (conn == null) {
				throw new Exception("���������Ӳ�����ȷ��");
			}
			Date nowDate = null;
			Date nextDate = null;

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// ��ʼ���ڽ������ڶ�Ϊ�գ�Ϊ�������˵���
				nowDate = new java.util.Date();
				nextDate = EASWUtils.getNextDay(nowDate);
			} else {
				nowDate = f.parse(beginDate);
				nextDate = f.parse(endDate);
				nextDate = EASWUtils.getNextDay(nextDate);
			}
			setIDListMap(conn, f.format(nowDate), f.format(nextDate));// fID��easbillnumber
			PreparedStatement ptm = conn.prepareStatement(getQueryStr(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ptm.setDate(1, new java.sql.Date(nowDate.getTime()));
			ptm.setDate(2, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = ptm.executeQuery();

			ArrayList<Integer> tempBillNumList = new ArrayList<Integer>();// ����tempnumber
			StockTransferBillInfo info = null;
			String billNum = null, billNumKeep = null;
			String billType="��������";
			rs.last();
			int count = rs.getRow();// �������
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

				// ������ϸ�������info���б������
				if (!billNumKeep.equals(billNum)) {// billnumKeep��=billnum
					exeImportSave(ctx, info, tempBillNumList,billType);
					tempBillNumList.clear();
					billNumKeep = billNum;
					info = null;
				}

				// �����ﴴ��info������info������Ϣ
				if (!tempBillNumList.contains(barBillID)) {// tempBillNumList����billnum
					tempBillNumList.add(barBillID);
					try {
						info = exeImportAction(ctx, companyID, info, rs);// ִ�в���
					} catch (Exception e) {
						info = null;
					}
				}

				// ���ﴦ�����һ����Ϣ
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
			try {// ����µĲɹ���ⵥ����д������Ҫɾ������
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
				EASWUtils.insertLogs(ctx, logBean);// ������־
			}

		}
	}

	private StockTransferBillInfo exeImportAction(Context ctx, String companyID, StockTransferBillInfo info, ResultSet rs) throws EASBizException, BOSException, SQLException {

		// ���õ���ͷ
		if (info == null) {
			info = new StockTransferBillInfo();
			String number = "";
			// ����µ�number
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
							new ObjectUuidPK("d8e80652-011b-1000-e000-04c5c0a812202407435C")));// ҵ������
			info.setCU((CtrlUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, companyID, OrgType.ControlUnit, null));
			StorageOrgUnitInfo storageOrgUnitInfo=ContextUtil.getCurrentStorageUnit(ctx);
			info.setIssueStorageOrgUnit(storageOrgUnitInfo);//���������֯��Ĭ����˹��
			info.setReceiptStorageOrgUnit(storageOrgUnitInfo);//��������֯��Ĭ����˹��
//			info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(
//			new ObjectUuidPK("1aa51711-0f60-455a-a3c2-43b86155098dB008DCA7")));// ��������


		}
		// ���÷�¼
		StockTransferBillEntryInfo entryInfo = new StockTransferBillEntryInfo();
		String materialNum;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		MaterialCollection mColl;
		MaterialInfo mInfo = null;
		EntityViewInfo ev;
		FilterInfo filter;
		// ���ϱ����Ӧת��
		materialNum = EASWUtils.getEASMaterialNumber(ctx, rs.getString("FMaterialNum"));// ���ϱ���
		ev = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number", materialNum, CompareType.EQUALS));
		ev.setFilter(filter);
		mColl = ims.getMaterialCollection(ev);// �������ϱ����ȡ����
		if (mColl != null && mColl.size() > 0) {
			SelectorItemCollection slr = new SelectorItemCollection();
			slr.add(new SelectorItemInfo("*"));
			mInfo = ims.getMaterialInfo(new ObjectUuidPK(mColl.get(0).getString("id")),slr);// ����
			entryInfo.setMaterial(mInfo);
			entryInfo.setBaseUnit(mInfo.getBaseUnit());
			entryInfo.setUnit(mInfo.getBaseUnit());
			String storageOrgUnitID=null;
			if(ContextUtil.getCurrentStorageUnit(ctx).getId().toString()!=null){
				storageOrgUnitID=ContextUtil.getCurrentStorageUnit(ctx).getId().toString();
			}
			entryInfo.setIssueWarehouse(EASWUtils.getDefaultYLWareHouse(ctx, storageOrgUnitID));//�����ֿ�Ϊԭ��Ĭ�ϲֿ�
			entryInfo.setReceiptWarehouse(EASWUtils.getDefaultLLWareHouse(ctx, storageOrgUnitID));//����ֿ�Ϊ����Ĭ�ϲֿ�
			entryInfo.setQty(rs.getBigDecimal("FQty"));
			entryInfo.setBaseQty(entryInfo.getQty());
			entryInfo.setString("model", mInfo.getModel());
			entryInfo.setIssuePlanDate(info.getBizDate());
			entryInfo.setReceiptPlanDate(info.getBizDate());
			entryInfo.setStoreType(StoreTypeFactory.getLocalInstance(ctx).getStoreTypeInfo(new ObjectUuidPK("181875d5-0105-1000-e000-0111c0a812fd97D461A6")));
			

			info.getEntry().add(entryInfo);// ��������¼���뵽��������
		} else {
			return null;
		}

		return info;
	
	}

	/**
	 * ����ID
	 * 
	 * @param conn
	 * @param beginDate
	 * @param endDate
	 * @throws SQLException
	 */
	private void setIDListMap(Connection conn, String beginDate, String endDate) throws SQLException {
		this.idListMap = new HashMap<String, ArrayList<Integer>>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select *  ");// eas������ⵥno   
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
				// ��һ��
				stocktransferIDKeep = stocktransferID;
			}
			if (!stocktransferIDKeep.equals(stocktransferID)) {
				idListMap.put(stocktransferIDKeep, (ArrayList<Integer>) list.clone());
				stocktransferIDKeep = stocktransferID;
				list.clear();
			}
			// list�м���id
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
