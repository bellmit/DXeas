package com.kingdee.eas.farm.feedfactory.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.feedfactory.PurFrightCollection;
import com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection;
import com.kingdee.eas.farm.feedfactory.PurFrightEntryInfo;
import com.kingdee.eas.farm.feedfactory.PurFrightFactory;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.feedfactory.PurFrightInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PurFrightControllerBean extends AbstractPurFrightControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.PurFrightControllerBean");
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
    	PurFrightInfo info =  (PurFrightInfo)model;
//		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
//				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
//				info.getBaseStatus() != null){
//			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
//			
//		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		
		return super._save(ctx, model);
	}

@Override
protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
		EASBizException {
	PurFrightInfo info =  PurFrightFactory.getLocalInstance(ctx).getPurFrightInfo(pk);
	if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
			!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
			!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
		throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
		
	}
	super._delete(ctx, pk);
}

/**
 * 提交
 */
@Override
protected IObjectPK _submit(Context ctx, IObjectValue model)
		throws BOSException, EASBizException {
	PurFrightInfo billInfo = (PurFrightInfo)model;
	if(billInfo != null  && 
			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
						billInfo.getBaseStatus() == null)){
		
		
		PurFrightEntryCollection  infoc = billInfo.getEntrys();
		for(int i=0;i<infoc.size();i++){
			PurFrightEntryInfo infoe = infoc.get(i);
			if(infoe.getWarehouse()== null){
				throw new EASBizException(new NumericExceptionSubItem("001","第"+i+1+"行分录的仓库不能为空"));	
			}
		}
		
		
		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
		
		
		return super._submit(ctx, model);
	}else{
		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
		
	}
	
	
	
}
/**
 * 审核
 */
@Override
protected void _audit(Context ctx, IObjectValue model) throws BOSException {
	PurFrightInfo billInfo = (PurFrightInfo)model;
	
	if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
		
		try {
			billInfo = this.getPurFrightInfo(ctx, new ObjectUuidPK(billInfo.getId()));
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_PurFright", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			billInfo.setBaseStatus( BillBaseStatusEnum.AUDITED);
    		// 保存更新后的单价
			super._save(ctx,billInfo);
		} catch (EASBizException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
		
	}else{
		throw new FarmException("只能审核提交状态的单据");
	}
	}
	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		PurFrightInfo billInfo = (PurFrightInfo)model;
		
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_PurFright", billInfo.getId().toString(), BillBaseStatusEnum.SUBMITED);
			billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
		
	}
	
}
    
    
    
    
    
    
    
