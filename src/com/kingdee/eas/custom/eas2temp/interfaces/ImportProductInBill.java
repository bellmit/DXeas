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
	 * ͨ��botp����������ⵥ
	 */
	public String importBillByBotp(Context ctx, String companyID,
			String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					TargetSystem.BARSYSTEM_VALUE);// �õ�����
			if (conn == null) {
				throw new Exception("��ȷ�����Ӳ���������ȷ");
			}

			PreparedStatement ptm = conn.prepareStatement(getQueryStr(),
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			//�趨ʱ��
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
			HashSet<String> sourceBillIDs = new HashSet<String>();// ��������������id
			HashMap<String, BigDecimal> qtyMap = new HashMap<String, BigDecimal>();// ����
			String billNum = null, billNumKeep = null;// temp���ݱ���
			String materialNum;// ���ϱ���
			String billType = "������ⵥ";
			BigDecimal qty = BigDecimal.ZERO;// ͬһ���ϵ��ۼ�����
			rs.last();
			boolean lasthasimported=false;
			int count = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				int barBillID = rs.getInt("ID");// ��Ʒ��ⵥid
				if (EASWUtils.checkHasImported(ctx, barBillID, billType)) {
					if(rs.getRow()==count){//���һ�������Ѿ������ˣ������Ҫ��ִ��һ��
						lasthasimported=true;
					}else{
						continue;
					}
				}
				billNum = rs.getString("erpBillNo");// ������������
				if (StringUtils.isBlank(billNum)) {
					continue;
				}
				if (rs.getRow() == 1 || StringUtils.isBlank(billNumKeep)) {
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx, ContextUtil
							.getCurrentCtrlUnit(ctx).getString("id"), billNum));// eas�ɹ�����id
				}
				// ʹ��botp���е��룬ʹ��<=����Ϊ�����һ�����ݺ͵����ڶ�����ͬ���������һ������ǰ�ȵ���ǰ�������
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
							.getCurrentCtrlUnit(ctx).getString("id"), billNum));// easԴ����number
				}
				String barmaterialNum = rs.getString("CPID");// �����Ʒ���ϱ���
				// �˴� ����ת�� ������������������������־
				materialNum = EASWUtils.getEASMaterialNumber(ctx,
						barmaterialNum);
				if (materialNum == "") {
					LogBean logBean = new LogBean();
					logBean.setBosType("");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("�������������ϱ���Ϊ��" + barmaterialNum + " �Ķ�Ӧ��ϵ");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
							.getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(rs.getInt("ID")));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}

				qty = rs.getBigDecimal("RSL");// �������
				if (qty == null) {
					qty = BigDecimal.ZERO;
				}
				if (!qtyMap.containsKey(materialNum)) {// ���Ϻ�������Ӧ,����������������һ����
					// ��������������ۼ�
					qtyMap.put(materialNum, qty);
				} else {
					qty = qty.add(qtyMap.get(materialNum));
					qtyMap.put(materialNum, qty);
				}
				tempBillIDList.add(barBillID);
				// ���һ����¼ֱ��ִ��botp
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
	 * ִ�е���ת��
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
				new FilterItemInfo("id", sourceBillIDs, CompareType.INCLUDE));// Դ����id
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
		IManufactureOrder imf = ManufactureOrderFactory.getLocalInstance(ctx);// �ɱ�����Ϊ���������ϵĳɱ�����
		SelectorItemCollection slr = new SelectorItemCollection();
		slr.add("*");
		slr.add(new SelectorItemInfo("costObject.*"));
		ManufactureOrderInfo mfoinfo = imf.getManufactureOrderInfo(
				new ObjectUuidPK(sourceBillID), slr);

		// ������������
		if (info == null) {
			return;
		}
		String id = info.getString("id");

		// ���õ�����
		info.setDescription("");// ��ע
		info.setBillType(BillTypeFactory.getLocalInstance(ctx).getBillTypeInfo(new ObjectUuidPK("50957179-0105-1000-e000-0167c0a812fd463ED552")));
		info.setBizType(BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("Nz878AEgEADgAABFwKg/GiQHQ1w=")));//ҵ������ ��ͨ�������
		//�������͸���botp�Զ�����
//		info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("DawAAAAPoCqwCNyn")));// �������� �깤�ϸ����

		info.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(
				ctx, info.getStorageOrgUnit().getId().toString()));// ���óɱ�����--
																	// ���ݿ����֯��ȡĬ�ϳɱ�����

		// ��¼����
		ManufactureRecBillEntryInfo entryInfo;

		// ɾ��û�����ϵ�������ⵥ��¼
		for (int index = 0; index < info.getEntry().size();) {
			if (index > info.getEntry().size()) {// ������¼������
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
		// ����������ⵥ��¼�ֶ�ֵ
		for (int index = 0; index < info.getEntry().size(); index++) {
			entryInfo = info.getEntry().get(index);
			entryInfo.setQty(qtyMap.get(entryInfo.getMaterial().getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
			WarehouseInfo warehouse = EASWUtils.getDefaultByMaterial(ctx,ContextUtil.getCurrentOrgUnit(ctx).getId().toString(),entryInfo.getMaterial().getId().toString());
			if (warehouse == null) {// �������Ĭ�ϲֿ�Ϊ�գ���ȥ��ƷĬ�ϲֿ�
				warehouse = EASWUtils.getDefaultCPWareHouse(ctx, ContextUtil.getCurrentOrgUnit(ctx).getId().toString());
			}
			//��������Ĭ�ϲֿ�
			entryInfo.setWarehouse(warehouse);
			//���óɱ�����
			entryInfo.setCostObject(mfoinfo.getCostObject());
			//���óɱ�����
			entryInfo.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));//���óɱ�����-- ���ݿ����֯��ȡĬ�ϳɱ�����
			
			//���ø�������--��ͨ���2016-03-05����
			//****add @20160305
			  TransactionTypeInfo transactionType = info.getTransactionType();
			  //InvUpdateTypeInfo invUpdateTypeInfo = null;
//			  try {
//				  invUpdateTypeInfo = TransactionTypeFactory.getLocalInstance(ctx).getDefaultInvUpdateType(transactionType.getId().toString());
//			  }
//			  catch (Exception e)
//			  {
//			  }
//			  entryInfo.setInvUpdateType(invUpdateTypeInfo);//�������� add@20160305
			  //*****
			
		}

		IObjectPK pk = null;
		try {
			pk = ips.save(info);
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e) {
			msg = e.getMessage();
			isSuccess = false;
			if (pk != null) {// ��дʧ����Ҫɾ��
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
			EASWUtils.insertLogs(ctx, logBean);// ������־

		}

	}

	/**
	 * ������ⵥ��¼��
	 */
	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return "cprk_productIn";
	}

	/**
	 * ������ⵥ�������
	 */
	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "v_EnterStockCP";
	}

	public String getEASBosType() {
		// ������ⵥBosType
		return "FA1292B4";
	}

	public String getEASSourceBosType() {
		// ��������BosType
		return "1D0D80DD";
	}

	public String getQueryStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");// ID,CPID,PBBH,LOT,RDate,RSL,RNO,bz,erpBillNo
		sql.append(" from ").append(getTempHeadTable());
		sql.append(" where 1=1 ");
		sql.append(" and RDate>=?");// �������
		sql.append(" and RDate<=?");// CreationDate
		sql.append(" order by CPID,ID");// ͨ�����ϱ����billid������
		return sql.toString();
	}

	/**
	 * �õ���Դ EAS ����id
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
		// ������������
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
