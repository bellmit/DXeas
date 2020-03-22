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
	 * ͨ��botp����ɹ���ⵥ
	 */
	public String importBillByBotp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {

		Connection conn = null;

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);// �õ�����
			if (conn == null) {
				throw new Exception("��ȷ�����Ӳ���������ȷ!");
			}
//			Date nowDate = new java.util.Date();
//			Date nextDate = EASWUtils.getNextDay(nowDate);
			
			PreparedStatement ptm = conn.prepareStatement(getQueryStr(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			//�趨ʱ�����
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
			HashSet<String> sourceBillIDs = new HashSet<String>();// �����ɹ�������id
			HashMap<String, BigDecimal> qtyMap = new HashMap<String, BigDecimal>();// ����
			String billNum = null, billNumKeep = null;// temp���ݱ���
			String materialNum;// ���ϱ���
			String billType="�ɹ���ⵥ";
			BigDecimal qty = BigDecimal.ZERO;// ͬһ���ϵ��ۼ�����
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			while (rs.next()) {
				int barBillID=rs.getInt("ID");
				
				
				//����ɹ�������Ϊ�գ�������
				
				if(rs.getString("po")==null){
					LogBean logBean=new LogBean();
					logBean.setBosType("783061E3");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("�ɹ�������Ϊ�յ�����δ����");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(barBillID));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}
				billNum = rs.getString("po").trim().replace(" ", "");// ����ϵͳ�б����eas�ɹ���������,ȥ��ǰ��ո�ȥ���м�ո�
				if (rs.getRow() == 1||StringUtils.isBlank(billNumKeep)) {
					billNumKeep = billNum;
					sourceBillIDs.add(getSourceBillID(ctx,ContextUtil.getCurrentCtrlUnit(ctx).getString("id"),billNum));// eas�ɹ�����id
				}
				if(EASWUtils.checkHasImported(ctx, barBillID,billType)&&billNum.equals(billNumKeep)){
					qtyMap.clear();
					continue;
				}
				// ʹ��botp���е���
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
					sourceBillIDs.add(getSourceBillID(ctx,ContextUtil.getCurrentCtrlUnit(ctx).getString("id"),billNum));// eas�ɹ�����number
				}
						
				String	barmaterialNum = rs.getString("Ylid");// ��ȡ����num
				
				//�˴� ����ת��   ������������������������־
				materialNum=EASWUtils.getEASMaterialNumber(ctx, barmaterialNum);
				if(materialNum==""){
					LogBean logBean=new LogBean();
					logBean.setBosType("783061E3");
					logBean.setDirection(logBean.Direction_Import);
					logBean.setEasBillID("");
					logBean.setMsg("�������������ϱ���Ϊ��"+barmaterialNum+" �Ķ�Ӧ��ϵ");
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
					logBean.setSuccess(false);
					logBean.setTempBillID(String.valueOf(barBillID));
					EASWUtils.insertLogs(ctx, logBean);
					continue;
				}
				qty = rs.getBigDecimal("RZL");// ��ȡ����
				if (qty == null) {
					qty = BigDecimal.ZERO;
				}
				if (!qtyMap.containsKey(materialNum)) {// ���Ϻ�������Ӧ,����������������һ������������������ۼ�
					qtyMap.put(materialNum, qty);
				} else {
					qty = qty.add(qtyMap.get(materialNum));
					qtyMap.put(materialNum, qty);
				}
				tempBillIDList.add(barBillID);

				// ���һ����¼ֱ��ִ��botp
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
	 * ִ�е���ת��
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
		//���õ�����
		
		// �������ͣ���ͨ�ɹ�/ί�����
		info.setTransactionType(TransactionTypeFactory.getLocalInstance(ctx).getTransactionTypeInfo(new ObjectUuidPK("DawAAAAPoACwCNyn")));
		//���óɱ�����--���ݿ����֯��ȡĬ�ϳɱ�����
		info.setCostCenterOrgUnit(EASWUtils.getMaterialReqDefaultCostCenter(ctx, info.getStorageOrgUnit().getId().toString()));
//		info.setPaymentType(PaymentTypeFactory.getLocalInstance(ctx).getPaymentTypeInfo(new ObjectUuidPK("")));
		//��¼����
		PurInWarehsEntryInfo entryInfo;
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		//ɾ��û�����ϵĲɹ���ⵥ��¼
		for (int index = 0; index < info.getEntry().size();) {
			if(index>=info.getEntry().size()) {//������¼������
				break;
			}
			entryInfo = info.getEntry().get(index);
			if(!qtyMap.containsKey(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber())) {//����ļ�¼�в����вɹ���ⵥ��¼������
				info.getEntry().removeObject(index);
				continue;
			}
			index++;
		}
		//���òɹ���ⵥ��¼�ֶ�ֵ
		for (int index = 0; index < info.getEntry().size(); index++) {
			entryInfo = info.getEntry().get(index);
			entryInfo.setQty(qtyMap.get(ims.getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())).getNumber()));
			entryInfo.setBaseQty(entryInfo.getQty());
			entryInfo.setPrice(entryInfo.getTaxPrice().divide(BigDecimal.ONE.add(entryInfo.getTaxRate()),4,BigDecimal.ROUND_HALF_UP));//����
			entryInfo.setUnitActualCost(entryInfo.getPrice());//��λʵ�ʳɱ�
			entryInfo.setUnitPurchaseCost(entryInfo.getPrice());//��λʵ�ʳɱ�
			entryInfo.setTaxAmount(entryInfo.getTaxPrice().multiply(entryInfo.getQty()));//��˰�ϼ�
			entryInfo.setLocalTaxAmount(entryInfo.getTaxAmount());//��˰�ϼƱ�λ��
			entryInfo.setAmount(entryInfo.getPrice().multiply(entryInfo.getQty()));//���
			entryInfo.setActualCost(entryInfo.getAmount());//ʵ�ʳɱ�
			entryInfo.setPurchaseCost(entryInfo.getAmount());//�ɹ��ɱ�
			entryInfo.setTax(entryInfo.getActualCost().multiply(entryInfo.getTaxRate()));//˰��
			entryInfo.setLocalTax(entryInfo.getTax());//˰�λ��
			entryInfo.setActualTaxPrice(entryInfo.getTaxPrice());//ʵ�ʺ�˰����
			//�ֿ�
			WarehouseInfo defaultWarehouse=EASWUtils.getDefaultByMaterial(ctx, ContextUtil.getCurrentStorageUnit(ctx).getId().toString(), entryInfo.getMaterial().getId().toString());
			if(defaultWarehouse==null){//�������Ĭ�ϲֿ�Ϊ�գ���ȡ���õ�Ĭ��ԭ�Ͽ�
				defaultWarehouse=EASWUtils.getDefaultYLWareHouse(ctx,  ContextUtil.getCurrentStorageUnit(ctx).getId().toString());
			}
			entryInfo.setWarehouse(defaultWarehouse);
			entryInfo.setBigDecimal("purOrderQty", purOrderQtyMap.get(entryInfo.getMaterial().getId().toString()).setScale(4));
			//���ø�������--��ͨ���2016-03-05����
			//****add @20160305
			  TransactionTypeInfo transactionType = info.getTransactionType();
//			  InvUpdateTypeInfo invUpdateTypeInfo = null;
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
			pk = ips.save(info);//����ɹ���ⵥ
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e) {
			isSuccess=false;
			msg=e.getMessage();
			if (pk != null) {// ��дʧ����Ҫɾ��
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
			EASWUtils.insertLogs(ctx, logBean);// ������־
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
			throw new EASBizException(new NumericExceptionSubItem("001","sql��ѯʧ��"));
		}
	}

	/**
	 * ����м���вɹ���ⵥ�ĵ���ͷtable
	 */
	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "v_EnterStock";
	}

	public String getEASBosType() {
		//�ɹ�����BosType
		return "783061E3"; 
	}

	public String getEASSourceBosType() {
		//�ɹ�����BosType
		return "3171BFAD";
		
	}

	/**
	 * ���Ҫ���������
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
	 * �õ� ��Դeas id
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
				throw new EASBizException(new NumericExceptionSubItem("001","��ѯ�����ɹ���������Ϊ��"+TempSourceBillNum));
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
