package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import org.apache.commons.lang.StringUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.OtherStorageBillCollection;
import com.kingdee.eas.weighbridge.OtherStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.weighbridge.OtherStorageBillInfo;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OtherStorageBillControllerBean extends AbstractOtherStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.OtherStorageBillControllerBean");
    private static final String purInwareBosType="783061E3";//new PurInWarehsBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//�����ѹ��������ֶ�
	private static final String OrderEntryBosType="";//����BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
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
			checkSaleOrderBillFlag(ctx,info.getPurOrderNumber());
			DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		//info.
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		IObjectPK pk =  super._save(ctx, model);
		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		//updatePurorder(ctx,info);

		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		//����ɡ��ʼ�����޸�״̬Ϊ���
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);

		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		checkSaleOrderBillFlag(ctx,info.getPurOrderNumber());
		DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		updatePurorder(ctx,info);

		return pk;
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
	private void updatePurorder(Context ctx,OtherStorageBillInfo info) throws BillBaseException{
		try{
			String orderNumber = info.getPurOrderNumber();

			if(StringUtils.isNotBlank(orderNumber)){

				// ע�� ֻȡ��һ��  ������¼���бȽ� ������ԭ�ϲɹ���ֻ��һ�з�¼���������͹���  ���������㷨
				//String searchSql = "select t.cfisSettleBySupplierQty,t.fid,te.fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid and te.fseq=1   where fnumber = ?";
				//yumingxu 0417
				String searchSql = "select t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,sum(te.fbaseqty) fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ?  group by t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate";
				String searchSqls = "select te.FPrice from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ? and te.fseq = 1";

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
					
					// ��ӹ�����ϵ
					BotpAppCommon.addRelations(ctx, "3171BFAD", orderID, this.getBOSType().toString(), info.getId().toString());

					// ���� ��������
					BigDecimal baseQty = rs.getBigDecimal("fbaseqty");
					if(baseQty == null) baseQty = new BigDecimal("0");


					// ����ͬ����ʱ  ���˹������أ�����������Ҫ�ȽϹ���������  ���� ��������������С��һ������ ��������
					
					//String upSql = "update t_sm_purorderentry set cfnetWeight=?,cfconfirmInQty=? where fparentid=? and fmaterialid=?";
					//yumingxu ���²ɹ�������ͷ���������������غ;��ز���
					String upSql = "update t_sm_purorder set cfycts=?,cfycje=?,cfSumWeight=?,cfSumWeidiff=?,cflostweightAmount=?,cfsumkfreight=?,cfcyscdkz=? where fid=? ";
					BigDecimal netQty = new BigDecimal("0");
					BigDecimal yc = new BigDecimal("0");
					BigDecimal ycdate = new BigDecimal("0");
					for(int i = 0; i < info.getEntrys().size(); i++){
						OtherStorageBillEntryInfo entryInfo = info.getEntrys().get(i);
						if(entryInfo != null && entryInfo.getMaterial() != null){
							BigDecimal netQtys = entryInfo.getSuttle();
							String materialID = entryInfo.getMaterial().getId().toString();
							if(netQty != null ){
//								if(isSettleBySupplierQty){
//									//�Թ�Ӧ���������㣬�������  
//									String sql = "select CFWeightstand from CT_WHB_LosWeightStand order by fcreatetime desc "; 
//									IRowSet rss = DbUtil.executeQuery(ctx, sql);
//									if(rss.next()){
//										lostweghtstand = rss.getBigDecimal("CFWeightstand");
//									}
//									if(rsss.next()){
//										mprice = rsss.getBigDecimal("FPrice");
//									}	
//								}
//								if(isfreight){
//									//�е��˷�
//									if(StringUtils.isBlank(rs.getString("cffreght"))){
//										freght = BigDecimal.ZERO;
//									}else{
//										freght = rs.getBigDecimal("cffreght");
//									}
//									
//									
//								}
								
								netQty  = netQty.add(netQtys);
							}
							//������ؽ��
//							lostweghtstandweight = baseQty.subtract(netQty);
//							if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
//								lostweghtstandweight = baseQty.subtract(netQty).subtract(lostweghtstand);
//								if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
//									lostweghtstandAmount = lostweghtstandweight.multiply(mprice);
//								}else{
//									lostweghtstandAmount = BigDecimal.ZERO;
//								}
//								
//								
//							}
							//ѹ�����
							//��������-�ɳ�����-1=ѹ������
							
//							if(StringUtils.isBlank(rs.getString("cfsendcardate"))){
//								System.out.println("����ѹ������Ϊ��");
//							}else{
//								String datediff = getDatePoor(entryInfo.getWeighTime(),rs.getDate("cfsendcardate"));
//								BigDecimal datediffs = new BigDecimal(datediff);
//								ycdate = datediffs.subtract(new BigDecimal("1"));
//								if(ycdate.compareTo(BigDecimal.ZERO)==1){
//									System.out.println("ѹ������Ϊ"+ycdate);
//								}else{
//									ycdate = BigDecimal.ZERO;
//									System.out.println("ѹ��ʱ�����������ѹ�����");
//								}
//								
//							}	
							//yc = netQty.divide(new BigDecimal("1000"), 0, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal("5")).multiply(ycdate);
							
							//�Ѷ�Ϊ��λ 20180824
							//netQty = netQty.divide(new BigDecimal("1000"));
//							BigDecimal gbjz = netQty.divide(new BigDecimal("1000"),2,BigDecimal.ROUND_HALF_UP);
//							freght = freght.multiply(gbjz);
//							//��ѹ�����-���ؽ��
//							freght = freght.add(yc).subtract(lostweghtstandAmount);
						}
					}
					//yumingxu 20180427
					
					
					Object[] upArgs = {ycdate,yc,netQty,netQty.subtract(baseQty),lostweghtstandAmount,freght,lostweghtstandweight,orderID};
					DbUtil.execute(ctx,upSql, upArgs);
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
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
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

    
    
}