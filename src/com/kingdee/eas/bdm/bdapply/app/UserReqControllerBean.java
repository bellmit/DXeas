package com.kingdee.eas.bdm.bdapply.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.bdm.bdapply.UserReqInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.util.NumericExceptionSubItem;

public class UserReqControllerBean extends AbstractUserReqControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.bdm.bdapply.app.UserReqControllerBean");
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	UserReqInfo billInfo = (UserReqInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		
    		return super._save(ctx, model);
    	}else{
//    		throw new Exception("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		UserReqInfo billInfo = (UserReqInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		return super._submit(ctx, model);
    	}else{
//    		throw new Exception("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}
	

	/**
     * ���
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		UserReqInfo billInfo = (UserReqInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("�Ѿ��������ε��ݣ��������");
			}
			
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_BDM_UserReq", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new BOSException("ֻ������ύ״̬�ĵ���");
		}
		
	}


	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		UserReqInfo billInfo = (UserReqInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("�Ѿ��������ε��ݣ����ܷ����");
			}else{

			}
			
			
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_BDM_UserReq", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new BOSException("ֻ�ܷ�������״̬�ĵ���");
		}
	}
	
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		UserReqInfo billInfo = this.getUserReqInfo(ctx, pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		
    		super._delete(ctx, pk);
    		
    	}else{
//    		throw new Exception("ֻ��ɾ�������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ�������򱣴�״̬�ĵ���"));
    	}
		
	}

}