package com.kingdee.eas.farm.feedfactory.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class FeedFactoryTruckPlanControllerBean extends AbstractFeedFactoryTruckPlanControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.FeedFactoryTruckPlanControllerBean");
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// ״̬����Ϊ����
		FeedFactoryTruckPlanInfo info =  (FeedFactoryTruckPlanInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ����ݴ��������״̬�ĵ���"));
			
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// ״̬����Ϊ����
		FeedFactoryTruckPlanInfo info =  this.getFeedFactoryTruckPlanInfo(ctx, pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ���ݴ��������״̬�ĵ���"));
			
		}
		
	
		super._delete(ctx, pk);
	}
	
	/**
	 * �ύ
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		FeedFactoryTruckPlanInfo billInfo = (FeedFactoryTruckPlanInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�����򱣴�״̬�ĵ���"));
			
    	}
	}
	
	
	/**
     * ���
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		FeedFactoryTruckPlanInfo billInfo = (FeedFactoryTruckPlanInfo)model;
	
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}
			
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_FeedFactoryTruckPlan", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}
		
		
	}

	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		FeedFactoryTruckPlanInfo billInfo = (FeedFactoryTruckPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}else{
				// У�鵱ǰ�����Ƿ��Ѿ������� �ձ� 
				// TODO 
			}
		
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_FeedFactoryTruckPlan", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}
		
		
	}
}