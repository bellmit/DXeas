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
	 * 付款单付款时，若付款申请单的已付款金额+付款单实付金额=付款申请单审批金额，则设置付款申请单为'已关闭'
	 * @param ui
	 * @param isClosed
	 * @throws EASBizException
	 * @throws BOSException 
	 * @throws SQLException 
	 */
//	public static void functionClosedFromPayBill(Context ctx,String id) throws EASBizException, BOSException, SQLException{
//		//获取当前付款单的info
//		CoreBaseCollection coll = PaymentBillFactory.getLocalInstance(ctx).getCollection("where ID='"+id+"'");
//		if(coll.size()>1)
//			throw new EASBizException(new NumericExceptionSubItem("001","存在多个与该单据相同id的单据"));
//
//
//		PaymentBillInfo paymentInfo = (PaymentBillInfo)coll.get(0);//付款单
//		PaymentBillEntryInfo peymentEntryInfo=null;//付款单分录
//		PayRequestBillInfo payReqBillInfo=null;//付款申请单
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
		}//付款单付款总金额+分录累计付款金额总和


		UserInfo userInfo = (UserInfo) ctx.get(SysContextConstant.USERINFO);

		if(sumPaymentActualPay.compareTo(payReqBillInfo.getAuditAmount())==0){
			updatePayRequestBillSetIsLockedTrueServer(ctx,payReqBillInfo.getId().toString(),true,userInfo,new Date());
		}
	}

	/**
	 * 根据付款申请单分录获取上游单据
	 * @param ctx
	 * @param peymentEntryInfo
	 * @return
	 * @throws BOSException 查询语句执行失败时
	 * @throws SQLException 结果集异常时
	 */
	private static PayRequestBillInfo getSrcPayReqBillInfo(Context ctx,
			PaymentBillEntryInfo peymentEntryInfo) throws BOSException, SQLException {
		// TODO Auto-generated method stub
		String srcObjectId=null;//付款申请单的id
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
	 * 反付款
	 * @param ctx
	 * @param id
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws SQLException 
	 */
	public static void functionUnClosedFromPayBill(Context ctx,String id) throws EASBizException, BOSException, SQLException{
		//获取当前付款单的info
		CoreBaseCollection coll = PaymentBillFactory.getLocalInstance(ctx).getCollection("where ID='"+id+"'");
		if(coll.size()>1)
			throw new EASBizException(new NumericExceptionSubItem("001","存在多个与该单据相同id的单据"));
		
		PaymentBillInfo paymentInfo = (PaymentBillInfo)coll.get(0);//付款单
		PaymentBillEntryInfo paymentEntryInfo=null;//付款单分录
		PayRequestBillInfo payReqBillInfo=null;//付款申请单
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
	 * 设置单据状态
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
		sb.append(" CFisClosed=").append(boolValue).append(",");//是否关闭
		if(bool){
			sb.append(" CFClosePersonID='").append(userID).append("',");//设置关闭人
			sb.append(" CFUnClosePersonID=null,");//设置反关闭人
			sb.append(" CFCloseTime=to_date('"+time+"','yyyy-MM-dd:hh24:mi:ss')");//设置关闭时间
		}else{
			sb.append(" CFClosePersonID=null,");//设置关闭人
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
	 * 付款申请单审批通过时反写签呈
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
	 * 付款申请单反审核时修改签呈的内容
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
	 * 根据BoTP关联关系获取签呈的info
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
