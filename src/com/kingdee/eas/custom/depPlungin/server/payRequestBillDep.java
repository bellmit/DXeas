package com.kingdee.eas.custom.depPlungin.server;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMapping;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationEntryFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.BOTRelationInfo;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTable;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillEntryInfo;
import com.kingdee.eas.fi.ap.PayRequestBillFactory;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.cas.PaymentBillEntryInfo;
import com.kingdee.eas.fi.cas.PaymentBillFactory;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.hr.base.RelationFactory;
import com.kingdee.eas.hr.base.RelationInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class payRequestBillDep {

	/**
	 * �������ʱ�����������뵥���Ѹ�����+���ʵ�����=�������뵥�����������ø������뵥Ϊ'�ѹر�'
	 * @param ui
	 * @param isClosed
	 * @throws EASBizException
	 * @throws BOSException 
	 * @throws SQLException 
	 */
//	public static void functionClosedFromPayBill(Context ctx,String id) throws EASBizException, BOSException, SQLException{
//		//��ȡ��ǰ�����info
//		CoreBaseCollection coll = PaymentBillFactory.getLocalInstance(ctx).getCollection("where ID='"+id+"'");
//		if(coll.size()>1)
//			throw new EASBizException(new NumericExceptionSubItem("001","���ڶ����õ�����ͬid�ĵ���"));
//
//
//		PaymentBillInfo paymentInfo = (PaymentBillInfo)coll.get(0);//���
//		PaymentBillEntryInfo peymentEntryInfo=null;//�����¼
//		PayRequestBillInfo payReqBillInfo=null;//�������뵥
//
//
//		HashMap<String, Integer> entry=new HashMap<String, Integer>();
//		for(int i=0;i<paymentInfo.getEntries().size();i++){
//			peymentEntryInfo=paymentInfo.getEntries().get(i);
//			payReqBillInfo=getSrcPayReqBillInfo(ctx, peymentEntryInfo);
//			if(payReqBillInfo.getId()==null)
//				continue;
//			else if(entry.containsKey(payReqBillInfo.getId().toString()))
//				continue;
//			else if(!entry.containsKey(payReqBillInfo.getId().toString()))
//				entry.put(payReqBillInfo.getId().toString(), i);
//				checkPaymentBillCanClose(ctx,payReqBillInfo);
//		}
//	}

	private static void checkPaymentBillCanClose(Context ctx,
			PayRequestBillInfo payReqBillInfo) {
		// TODO Auto-generated method stub
		BigDecimal sumPaymentActualPay = BigDecimal.ZERO;

		PayRequestBillEntryInfo payRequestEntryInfo=null;
		for(int i=0;i<payReqBillInfo.getEntrys().size();i++){
			payRequestEntryInfo=payReqBillInfo.getEntrys().get(i);
			if(payRequestEntryInfo.getTotalPayAmt()!=null)
				sumPaymentActualPay=sumPaymentActualPay.add(payRequestEntryInfo.getTotalPayAmt());
		}//��������ܽ��+��¼�ۼƸ������ܺ�


		UserInfo userInfo = (UserInfo) ctx.get(SysContextConstant.USERINFO);

		if(sumPaymentActualPay.compareTo(payReqBillInfo.getAuditAmount())==0){
			updatePayRequestBillSetIsLockedTrueServer(ctx,payReqBillInfo.getId().toString(),true,userInfo,new Date());
		}
	}

	/**
	 * ���ݸ������뵥��¼��ȡ���ε���
	 * @param ctx
	 * @param peymentEntryInfo
	 * @return
	 * @throws BOSException ��ѯ���ִ��ʧ��ʱ
	 * @throws SQLException ������쳣ʱ
	 */
	private static PayRequestBillInfo getSrcPayReqBillInfo(Context ctx,
			PaymentBillEntryInfo peymentEntryInfo) throws BOSException, SQLException {
		// TODO Auto-generated method stub
		String srcObjectId=null;//�������뵥��id
		StringBuffer sb=new StringBuffer();
		sb.append("select FSourceBillId from T_CAS_PaymentBillEntry");
		sb.append(" where fid='").append(peymentEntryInfo.getId().toString()).append("'");

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		if(rs.next())
			srcObjectId=rs.getString("FSourceBillId");

		if(srcObjectId==null)
			return null;
		CoreBaseCollection coll = PayRequestBillFactory.getLocalInstance(ctx).getCollection("where id='"+srcObjectId+"'");
		if(coll.size()>0)
			return (PayRequestBillInfo) coll.get(0);
		return null;
	}



	/**
	 * ������
	 * @param ctx
	 * @param id
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws SQLException 
	 */
	public static void functionUnClosedFromPayBill(Context ctx,String id) throws EASBizException, BOSException, SQLException{
		//��ȡ��ǰ�����info
		CoreBaseCollection coll = PaymentBillFactory.getLocalInstance(ctx).getCollection("where ID='"+id+"'");
		if(coll.size()>1)
			throw new EASBizException(new NumericExceptionSubItem("001","���ڶ����õ�����ͬid�ĵ���"));
		
		PaymentBillInfo paymentInfo = (PaymentBillInfo)coll.get(0);//���
		PaymentBillEntryInfo paymentEntryInfo=null;//�����¼
		PayRequestBillInfo payReqBillInfo=null;//�������뵥
		UserInfo userInfo = (UserInfo) ctx.get(SysContextConstant.USERINFO);


		HashMap<String, Integer> entry=new HashMap<String, Integer>();
		for(int i=0;i<paymentInfo.getEntries().size();i++){
			paymentEntryInfo=paymentInfo.getEntries().get(i);
			payReqBillInfo=getSrcPayReqBillInfo(ctx, paymentEntryInfo);
			if(payReqBillInfo.getId()==null)
				continue;
			else if(entry.containsKey(payReqBillInfo.getId().toString()))
				continue;
			else if(!entry.containsKey(payReqBillInfo.getId().toString()))
				entry.put(payReqBillInfo.getId().toString(), i);
				updatePayRequestBillSetIsLockedTrueServer(ctx,payReqBillInfo.getId().toString(), false,userInfo,new Date());
		}



		
		
	}
	/**
	 * ���õ���״̬
	 * @param ID
	 * @param status
	 */
	private static void updatePayRequestBillSetIsLockedTrueServer(Context ctx,String payRequestBillID,boolean bool,UserInfo userInfo,
			Date date) {
		// TODO Auto-generated method stub		
		int boolValue=0;
		if(bool)
			boolValue=1;
		else
			boolValue=0;
		String userID="";
		if(userInfo.getId()!=null)
			userID=userInfo.getId().toString();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);

		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/update T_AP_PayRequestBill set");
		sb.append(" CFisClosed=").append(boolValue).append(",");//�Ƿ�ر�
		if(bool){
			sb.append(" CFClosePersonID='").append(userID).append("',");//���ùر���
			sb.append(" CFUnClosePersonID=null,");//���÷��ر���
			sb.append(" CFCloseTime=to_date('"+time+"','yyyy-MM-dd:hh24:mi:ss')");//���ùر�ʱ��
		}else{
			sb.append(" CFClosePersonID=null,");//���ùر���
			sb.append(" CFUnClosePersonID='").append(userID).append("',");
			sb.append(" CFCloseTime=null");
		}
		sb.append(" where fid='"+payRequestBillID+"'");
		try {
			SQLExecutorFactory.getLocalInstance(ctx,sb.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �������뵥����ͨ��ʱ��дǩ��
	 * @param ctx
	 * @param id
	 * @throws EASBizException
	 * @throws BOSException
	 */
//	public static void rewriteSignTableFromPayReqWhenAuditPass(Context ctx, String id) throws EASBizException, BOSException{
//		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
//
//
//		SignWasTheTableInfo signTableInfo=getSignTableFromBotpRelation(ctx,info);
//
//		BigDecimal sum = BigDecimal.ZERO;
//		if(signTableInfo!=null){
//			if(signTableInfo.getPayReq().size()>0){
//				PayRequestBillEntryCollection entrys = info.getEntrys();
//				for(int i=0;i<entrys.size();i++)
//					if(entrys.get(i).getAuditAmount()!=null)
//						sum=sum.add(entrys.get(i).getAuditAmount());
//				BigDecimal reqPayAmt = BigDecimal.ZERO;
//				if(signTableInfo.getPayStatus().get(0).getReqPayAmt()!=null)
//					reqPayAmt=signTableInfo.getPayStatus().get(0).getReqPayAmt();
//				reqPayAmt=reqPayAmt.add(sum);
//				signTableInfo.getPayStatus().get(0).setReqPayAmt(reqPayAmt);
//				signTableInfo.getPayStatus().get(0).setUnReqPayAmt(signTableInfo.getPayStatus().get(0).getPayAmt().subtract(reqPayAmt));
//				SignWasTheTableFactory.getLocalInstance(ctx).save(new ObjectUuidPK(signTableInfo.getId().toString()),signTableInfo);
//			}
//		}
//	}


	/**
	 * �������뵥�����ʱ�޸�ǩ�ʵ�����
	 * @param ctx
	 * @param id
	 * @throws EASBizException
	 * @throws BOSException
	 */
//	public static void rewriteSignTableFromPayReqWhenUnAudit(Context ctx, String id) throws EASBizException, BOSException{
//		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
//
//
//		SignWasTheTableInfo signTableInfo=getSignTableFromBotpRelation(ctx,info);
//
//		BigDecimal sum = BigDecimal.ZERO;
//		if(signTableInfo!=null){
//			if(signTableInfo.getPayReq().size()>0){
//				PayRequestBillEntryCollection entrys = info.getEntrys();
//				for(int i=0;i<entrys.size();i++)
//					if(entrys.get(i).getAuditAmount()!=null)
//						sum=sum.add(entrys.get(i).getAuditAmount());
//				BigDecimal reqPayAmt = BigDecimal.ZERO;
//				if(signTableInfo.getPayStatus().get(0).getReqPayAmt()!=null)
//					reqPayAmt=signTableInfo.getPayStatus().get(0).getReqPayAmt();
//				reqPayAmt=reqPayAmt.subtract(sum);
//				signTableInfo.getPayStatus().get(0).setReqPayAmt(reqPayAmt);
//				signTableInfo.getPayStatus().get(0).setUnReqPayAmt(signTableInfo.getPayStatus().get(0).getPayAmt().subtract(reqPayAmt));
//				SignWasTheTableFactory.getLocalInstance(ctx).save(new ObjectUuidPK(signTableInfo.getId().toString()),signTableInfo);
//			}
//		}
//	}
	/**
	 * ����BoTP������ϵ��ȡǩ�ʵ�info
	 * @param ctx
	 * @param info
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private static SignWasTheTableInfo getSignTableFromBotpRelation(
			Context ctx, PayRequestBillInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub		
		EntityViewInfo evi = getEntityViewInfoSetting(info);

		BOTRelationInfo botRelationInfo=null;
		BOTRelationCollection coll = BOTRelationFactory.getLocalInstance(ctx).getCollection(evi);
		if(coll.size()>0)
			botRelationInfo=coll.get(0);
		else
			return null;
		String ID = botRelationInfo.getSrcObjectID();
		return SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableInfo(new ObjectUuidPK(ID))!=null?SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableInfo(new ObjectUuidPK(ID)):null;
	}

	private static EntityViewInfo getEntityViewInfoSetting(
			PayRequestBillInfo info) {
		// TODO Auto-generated method stub
		//		IBOTMapping IBotMapping = BOTMappingFactory.getLocalInstance(ctx);
		//		CoreBaseCollection BOTMappingColl=null;		
		//		ArrayList<String> botMappingInfo = new ArrayList<String>();
		//		for(int i=0;i<botMappingInfoName.length;i++){
		//		BOTMappingColl = IBotMapping.getCollection("where name='"+botMappingInfoName[i]+"' and alias='"+botMappingInfoAlias[i]+"'");
		//		if(BOTMappingColl.size()>0)
		//			botMappingInfo.add(((BOTMappingInfo) BOTMappingColl.get(0)).getId().toString());
		//		}
		//		String[] botMappingInfos = new String[botMappingInfo.size()];
		//		for(int i=0;i<botMappingInfo.size();i++)
		//			botMappingInfos[i]=botMappingInfo.get(i);




		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("DestObjectID",info.getId().toString(),CompareType.EQUALS));
		//		filterInfo.getFilterItems().add(new FilterItemInfo("BOTMappingID",botMappingInfos,CompareType.INNER));
		evi.setFilter(filterInfo);
		return evi;
	}


}
