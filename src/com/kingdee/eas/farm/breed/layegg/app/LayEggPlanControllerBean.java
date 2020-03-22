package com.kingdee.eas.farm.breed.layegg.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class LayEggPlanControllerBean extends AbstractLayEggPlanControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.layegg.app.LayEggPlanControllerBean");
    

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// ״̬����Ϊ����
		LayEggPlanInfo info =  (LayEggPlanInfo)model;
		
		checkExist(ctx,info);
		
		
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ����ݴ��������״̬�ĵ���"));
			
		}
		
		if(info.getFarm() == null){
			info.setFarm(ContextUtil.getCurrentStorageUnit(ctx));
			
		}
		
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	/**
	 * У�� �Ϸ���û�����òŻ�����ɾ��
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		LayEggPlanInfo info =  LayEggPlanFactory.getLocalInstance(ctx).getLayEggPlanInfo(pk);
		
		
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
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
		LayEggPlanInfo billInfo = (LayEggPlanInfo)model;
		
		checkExist(ctx,billInfo);
		
		
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		
    		if(billInfo.getFarm() == null){
    			billInfo.setFarm(ContextUtil.getCurrentStorageUnit(ctx));    			
    		}
    		
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
		LayEggPlanInfo billInfo = (LayEggPlanInfo)model;
		
		
			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
				if(exist){
					throw new FarmException("�Ѿ��������ε��ݣ��������");
				}
				
				// ���µ���״̬
				AppCommon.updateModelStatus(ctx, "CT_FM_LayEggPlan", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
				
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
		
		LayEggPlanInfo billInfo = (LayEggPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_LayEggPlan", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}
		
	}
	/**
	 * ���鵱�µĲ����ƻ��Ƿ��Ѿ�¼��
	 */
	protected void checkExist(Context ctx, LayEggPlanInfo info) throws EASBizException{
		StringBuffer sb=new StringBuffer();
		sb.append("select * from CT_FM_LayEggPlan where CFFarmID=? and CFPeriodID=? and fid<>?");
		String str = "";
		if(info.getId()!=null)
			str=info.getId().toString();
		String[] args = {info.getFarm().getId().toString(),info.getPeriod().getId().toString(),str};
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString(), args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","�Ѵ��ڵ�ǰ�ڼ�Ĳ����ƻ����벻Ҫ�ظ�¼��"));
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