package com.kingdee.eas.custom.depPlungin.server;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.BOTRelationInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillFactory;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.cas.PaymentBillEntryCollection;
import com.kingdee.eas.fi.cas.PaymentBillFactory;
import com.kingdee.eas.fi.cas.PaymentBillInfo;

public class paymentBillDep {

	/**
	 * 付款单审付款时反写签呈
	 * @param ctx
	 * @param id
	 * @throws EASBizException
	 * @throws BOSException
	 */
//	public static void rewriteSignTableFromPayWhenPay(Context ctx, String id) throws EASBizException, BOSException{
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//
//
//		SignWasTheTableInfo signTableInfo=getSignTableFromBotpRealation(ctx,info);
//
//		BigDecimal sum = BigDecimal.ZERO;
//		if(signTableInfo!=null){
//			if(signTableInfo.getPayReq().size()>0){
//				PaymentBillEntryCollection entrys = info.getEntries();
//				for(int i=0;i<entrys.size();i++)
//					if(entrys.get(i).getAmount()!=null)
//						sum=sum.add(entrys.get(i).getAmount());
//				BigDecimal payAmt = BigDecimal.ZERO;
//				if(signTableInfo.getPayStatus().get(0).getPayedAmt()!=null)
//					payAmt=signTableInfo.getPayStatus().get(0).getPayedAmt();
//				payAmt=payAmt.add(sum);
//				signTableInfo.getPayStatus().get(0).setPayedAmt(payAmt);
//				signTableInfo.getPayStatus().get(0).setUnPayedAmt(signTableInfo.getPayStatus().get(0).getReqPayAmt().subtract(payAmt));
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
//	public static void rewriteSignTableFromPayWhenUnAudit(Context ctx, String id) throws EASBizException, BOSException{
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//
//
//		SignWasTheTableInfo signTableInfo=getSignTableFromBotpRealation(ctx,info);
//
//		BigDecimal sum = BigDecimal.ZERO;
//		if(signTableInfo!=null){
//			if(signTableInfo.getPayReq().size()>0){
//				PaymentBillEntryCollection entrys = info.getEntries();
//				for(int i=0;i<entrys.size();i++)
//					if(entrys.get(i).getAmount()!=null)
//						sum=sum.add(entrys.get(i).getAmount());
//				BigDecimal payAmt = BigDecimal.ZERO;
//				if(signTableInfo.getPayStatus().get(0).getReqPayAmt()!=null)
//					payAmt=signTableInfo.getPayStatus().get(0).getPayedAmt();
//				payAmt=payAmt.subtract(sum);
//				signTableInfo.getPayStatus().get(0).setPayedAmt(payAmt);
//				signTableInfo.getPayStatus().get(0).setUnPayedAmt(signTableInfo.getPayStatus().get(0).getReqPayAmt().subtract(payAmt));
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
	private static SignWasTheTableInfo getSignTableFromBotpRealation(
			Context ctx, PaymentBillInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub		
		EntityViewInfo evi = getEntityViewInfoSetting(info.getId().toString());

		BOTRelationInfo botRelationInfo=null;
		BOTRelationCollection coll = BOTRelationFactory.getLocalInstance(ctx).getCollection(evi);
		if(coll.size()>0)
			botRelationInfo=coll.get(0);
		else
			return null;
		String ID = botRelationInfo.getSrcObjectID();
		PayRequestBillInfo reqInfo=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(ID))==null?null:PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(ID));
		if(reqInfo==null)
			return null;
		
		
		evi=getEntityViewInfoSetting(reqInfo.getId().toString());
		coll = BOTRelationFactory.getLocalInstance(ctx).getCollection(evi);
		if(coll.size()>0)
			botRelationInfo=coll.get(0);
		ID = botRelationInfo.getSrcObjectID();
		
		
		return SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableInfo(new ObjectUuidPK(ID))!=null?SignWasTheTableFactory.getLocalInstance(ctx).getSignWasTheTableInfo(new ObjectUuidPK(ID)):null;
	}

	private static EntityViewInfo getEntityViewInfoSetting(
			String id) {
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
		filterInfo.getFilterItems().add(new FilterItemInfo("DestObjectID",id,CompareType.EQUALS));
		//		filterInfo.getFilterItems().add(new FilterItemInfo("BOTMappingID",botMappingInfos,CompareType.INNER));
		evi.setFilter(filterInfo);
		return evi;
	}
}
