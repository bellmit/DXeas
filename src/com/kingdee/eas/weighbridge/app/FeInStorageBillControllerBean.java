package com.kingdee.eas.weighbridge.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.ICCReceivingBill;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.FeInStorageBillFactory;
import com.kingdee.eas.weighbridge.FeInStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FeInStorageBillControllerBean extends AbstractFeInStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.FeInStorageBillControllerBean");
    
    private static final String purInwareBosType="783061E3";//new PurInWarehsBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//�����ѹ��������ֶ�
	private static final String OrderEntryBosType="";//����BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		//��ֹ�ظ���� 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//�����״̬���������
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}

		/*if(info.isIsAutoCreateToInvBill()) {
			WeighbridgeCommUtils.createToSCMBill(ctx, info, purInwareBosType);//�ɹ���ⵥ
		}*/

		info.setBillStatus(WeighBaseStatus.audit);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			//checkSaleOrderBillFlag(ctx,info.getPurnumber());
			//DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		//info.
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		IObjectPK pk =  super._save(ctx, model);
		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		//updatePurorder(ctx,info);

		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		//����ɡ��ʼ�����޸�״̬Ϊ���
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);

		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		checkSaleOrderBillFlag(ctx,info.getPurnumber());
		DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		if(info.getBizType().getValue().equals(WeighBizType.Pur)){
			updatePurorder(ctx,info);
		}else{
			updateQC(ctx,info);
		}

		return pk;
	}
	//�����ʼ쵥
	private void updateQC(Context ctx, FeInStorageBillInfo info) {
		// TODO Auto-generated method stub
		if(info.getPurnumber()!=null){
			String upDate = " update CT_FM_QualityCheckBill set CFIsWeight=1  where fnumber=? ";
			Object[] upDateArgs = {info.getPurnumber()};
			try {
				DbUtil.execute(ctx,upDate, upDateArgs);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/*
	 * У���������Ƿ�Ӧ�÷�д�ɹ�������  ������ɱ�־
	 */
	private void checkSaleOrderBillFlag(Context ctx, String purOrderNumber) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(purOrderNumber)){
			IRowSet rs;
			try {
				rs = DbUtil.executeQuery(ctx,"select t1.CFISHASWGTBILL,t2.FID from T_SM_PurOrder t1 left join CT_FM_QualityCheckBill t2 on t1.FID=t2.CFPurOrderID where t1.FNumber='"+purOrderNumber+"' order by t1.CFISHASWGTBILL desc ,t2.FID desc");
				if(rs.next()){
					//û��ʱ�����־
					if(rs.getBoolean("CFISHASWGTBILL")&&StringUtils.isEmpty(rs.getString("FID"))){
						DbUtil.execute(ctx,"update T_SM_PurOrder set CFisHasWgtBill=0 where FNumber='"+purOrderNumber+"'");
					}else if(!rs.getBoolean("CFISHASWGTBILL")&&StringUtils.isNotEmpty(rs.getString("FID"))){
						DbUtil.execute(ctx,"update T_SM_PurOrder set CFisHasWgtBill=1 where FNumber='"+purOrderNumber+"'");
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���²ɹ����� �������� �ͽ�������
	 * @param ctx
	 * @param info
	 * @throws BillBaseException 
	 */
	private void updatePurorder(Context ctx,FeInStorageBillInfo info) throws BillBaseException{
		try{
			String orderNumber = info.getPurnumber();

			if(StringUtils.isNotBlank(orderNumber)){

				// ע�� ֻȡ��һ��  ������¼���бȽ� ������ԭ�ϲɹ���ֻ��һ�з�¼���������͹���  ���������㷨
				//String searchSql = "select t.cfisSettleBySupplierQty,t.fid,te.fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid and te.fseq=1   where fnumber = ?";
				//yumingxu 0417
				String searchSql = "select t.cfisSettleBySupplierQty,t.FPurchaseOrgUnitID,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,sum(te.fbaseqty) fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ?  group by t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,t.FPurchaseOrgUnitID";
				String searchSqls = "select max(te.FPrice) FPrice from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ? ";

				Object[] args = {orderNumber};
				IRowSet rs = DbUtil.executeQuery(ctx, searchSql,args);
				IRowSet rsss = DbUtil.executeQuery(ctx, searchSqls,args);
				// ���ڶ���  �������� 
				if(rs.next()){

					Boolean isSettleBySupplierQty = rs.getBoolean("cfisSettleBySupplierQty");
					Boolean isfreight = rs.getBoolean("cfisfreight");
					String orderID = rs.getString("fid");
					//�˷ѵ���
					BigDecimal freght = new BigDecimal("0");
					//��˾�е�����
					BigDecimal lostweghtstand = new BigDecimal("0");
					BigDecimal lostweghtstandAmount = new BigDecimal("0");
					BigDecimal lostweghtstandweight = new BigDecimal("0");
					//ԭ�ϵ���
					BigDecimal mprice =  new BigDecimal("0");
					
					//�ɹ���֯
					String FPurchaseOrgUnitID = rs.getString("FPurchaseOrgUnitID");
					// ��ӹ�����ϵ
					BotpAppCommon.addRelations(ctx, "3171BFAD", orderID, this.getBOSType().toString(), info.getId().toString());

					// ���� ��������
					BigDecimal baseQty = rs.getBigDecimal("fbaseqty");
					if(baseQty == null) baseQty = new BigDecimal("0");


					// ����ͬ����ʱ  ���˹������أ�����������Ҫ�ȽϹ���������  ���� ��������������С��һ������ ��������
					
					//String upSql = "update t_sm_purorderentry set cfnetWeight=?,cfconfirmInQty=? where fparentid=? and fmaterialid=?";
					//yumingxu ���²ɹ�������ͷ���������������غ;��ز���
					String upSql = "/*dialect*/ update t_sm_purorder set cfycts=?,cfycje=?,cfSumWeight=?,cfSumWeidiff=?,cflostweightAmount=?,cfsumkfreight=?,cfcyscdkz=? where fid=? ";
					//String upDate = " update t_sm_purorder set cfoutdate=to_date(?,'yyyy-MM-dd')  where fid=? ";
					String upDate = " update t_sm_purorder set cfoutdate=SYSDATE  where fid=? ";

					BigDecimal netQty = new BigDecimal("0");
					BigDecimal yc = new BigDecimal("0");
					BigDecimal ycdate = new BigDecimal("0");
					for(int i = 0; i < info.getEntrys().size(); i++){
						FeInStorageBillEntryInfo entryInfo = info.getEntrys().get(i);
						if(entryInfo != null && entryInfo.getMaterial() != null){
							BigDecimal netQtys = entryInfo.getSuttle();
							String materialID = entryInfo.getMaterial().getId().toString();

							netQty  = netQty.add(netQtys);
							
							//ѹ�����
							//��������-�ɳ�����-1=ѹ������
							
							if(StringUtils.isBlank(rs.getString("cfsendcardate"))){
								System.out.println("����ѹ������Ϊ��");
							}else{
								String datediff = getDatePoor(entryInfo.getWeighTime(),rs.getDate("cfsendcardate"));
								BigDecimal datediffs = new BigDecimal(datediff);
								ycdate = datediffs.subtract(new BigDecimal("1"));
								if(ycdate.compareTo(BigDecimal.ZERO)==1){
									System.out.println("ѹ������Ϊ"+ycdate);
								}else{
									ycdate = BigDecimal.ZERO;
									System.out.println("ѹ��ʱ�����������ѹ�����");
								}
								
							}
							
						}
					}
					if(netQty != null ){
						if(isSettleBySupplierQty){
							//�Թ�Ӧ���������㣬�������  
							String sql = "select CFWeightstand from CT_WHB_LosWeightStand where CFCompanyID ='"+FPurchaseOrgUnitID+"' order by fcreatetime desc "; 
							IRowSet rss = DbUtil.executeQuery(ctx, sql);
							if(rss.next()){
								lostweghtstand = rss.getBigDecimal("CFWeightstand");
							}
							if(rsss.next()){
								mprice = rsss.getBigDecimal("FPrice");
							}
							//������ؽ��
							lostweghtstandweight = baseQty.subtract(netQty);
							if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
								lostweghtstandweight = baseQty.subtract(netQty).subtract(lostweghtstand);
								if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
									lostweghtstandAmount = lostweghtstandweight.multiply(mprice);
								}else{
									lostweghtstandAmount = BigDecimal.ZERO;
									lostweghtstandweight = BigDecimal.ZERO;
								}
								
								
							}
						}
						if(isfreight){
							//�е��˷�
							if(StringUtils.isBlank(rs.getString("cffreght"))){
								freght = BigDecimal.ZERO;
							}else{
								freght = rs.getBigDecimal("cffreght");
							}
 
							
						}
						
					}
					
						
					yc = netQty.divide(new BigDecimal("1000"), 0, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal("5")).multiply(ycdate);
					
					//�Ѷ�Ϊ��λ 20180824
					//netQty = netQty.divide(new BigDecimal("1000"));
					BigDecimal gbjz = netQty.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_HALF_UP);
					//freght = freght.multiply(gbjz);
					BigDecimal jbsl = baseQty.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_HALF_UP);

					freght = freght.multiply(jbsl).setScale(2, BigDecimal.ROUND_HALF_UP);
					//��ѹ�����-���ؽ��
					//freght = freght.add(yc).subtract(lostweghtstandAmount).setScale(2,BigDecimal.ROUND_HALF_UP);
					
					
					//yumingxu 20180427
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					//String dateString = formatter.format();
					//dateString = " to_date('"+dateString+"','yyyy-MM-dd')";
					Object[] upDateArgs = {orderID};
					Object[] upArgs = {ycdate,yc,netQty.setScale(0,BigDecimal.ROUND_HALF_UP),netQty.subtract(baseQty).setScale(0,BigDecimal.ROUND_HALF_UP),lostweghtstandAmount.setScale(2,BigDecimal.ROUND_HALF_UP),freght,lostweghtstandweight.setScale(0,BigDecimal.ROUND_HALF_UP),orderID};
					DbUtil.execute(ctx,upSql, upArgs);
					DbUtil.execute(ctx,upDate, upDateArgs);
				}
			}

			//			if(info.isIsAutoCreateToInvBill()) {
			//				WeighbridgeCommUtils.createToSCMBill(ctx, info, purInwareBosType);//�ɹ���ⵥ
			//			}
		}catch(Exception e) {
			throw new BillBaseException(new NumericExceptionSubItem("001",e.getMessage()));
		}
	}
	public static String getDatePoor(Date endDate, Date nowDate) {
		 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // �������ʱ��ĺ���ʱ�����
	    long diff = endDate.getTime() - nowDate.getTime();
	    // ����������
	    long day = diff / nd;
	    // ��������Сʱ
	    long hour = diff % nd / nh;
	    // �������ٷ���
	    long min = diff % nd % nh / nm;
	    // ����������//������
	    // long sec = diff % nd % nh % nm / ns;
	    return day+"" ;
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		//����ֹ�ظ����
		if(!info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		info.setBillStatus(WeighBaseStatus.save);
		info.setAuditTime(null);
		info.setAuditor(null);
		try {
			//����Ƿ�������ε���
			WeighbridgeCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	/**
	 * ������Ʒ�����յ�
	 * @throws BOSException 
	 */
	private void createCCReceiveBill(Context ctx, FeInStorageBillInfo info) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType��Ŀ�굥��BOS����
		ICCReceivingBill iInstace = null;
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		String bosType="4C3F10BD";//new CCReceivingBillInfo().getBOSType().toString();
		try {
			// ����BOTP�ӿ��Զ����ɵ���--��ⵥ
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [ע��]��ȡBTP�ı��ؽӿ�
			result = btp.transform(info, bosType);
			// [ע��] result��Ϊת���ɹ�����Ŀ�굥��
			// objectValue��Դ���ݵ�ֵ����
			destBillInfo = result.getBills().getObject(0);

			iInstace = CCReceivingBillFactory.getLocalInstance(ctx);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// Ŀ�굥��Id

			// [ע��] ���浥�ݵĹ���ϵͳ
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e1) {// botp ʧ�� ɾ������
			throw new BOSException(e1.getMessage());
		}
	}

	//����
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//����ֹ�ظ����
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ�����ֹ����"));
		}
		info.setBillStatus(WeighBaseStatus.cancel);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	/**
	 * ������
	 */
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		if(!info.getBillStatus().equals(WeighBaseStatus.cancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�õ���û�б����ϣ���������ʧ��"));
		}
		info.setBillStatus(WeighBaseStatus.save);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e); 
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FeInStorageBillInfo info = FeInStorageBillFactory.getLocalInstance(ctx).getFeInStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)||info.getBillStatus().equals(WeighBaseStatus.gross)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ɻ���ˣ���ֹɾ��"));
		}
		//String purOrderNum = info.getPurnumber();
		super._delete(ctx, pk);
		//checkSaleOrderBillFlag(ctx,purOrderNum);
	}
}