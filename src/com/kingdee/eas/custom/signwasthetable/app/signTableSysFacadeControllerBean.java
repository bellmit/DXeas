package com.kingdee.eas.custom.signwasthetable.app;

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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ContractTypeFactory;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.custom.signwasthetable.EngProjectFactory;
import com.kingdee.eas.custom.signwasthetable.EngProjectInfo;
import com.kingdee.eas.custom.signwasthetable.SignBDFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;

import java.lang.String;

public class signTableSysFacadeControllerBean extends AbstractsignTableSysFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.signTableSysFacadeControllerBean");
    /**
     *签呈类型基础资料的   禁用
     */
	@Override
	protected void _signTypeCancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
			SignBDInfo signTypeInfo = SignBDFactory.getLocalInstance(ctx).getSignBDInfo(new ObjectUuidPK(id));
			signTypeInfo.setBillStatus(UsedStatus.falseValue);
			SignBDFactory.getLocalInstance(ctx).save(signTypeInfo);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     *签呈类型基础资料的   启用
     */
	@Override
	protected void _signTypeCancelcancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
			SignBDInfo signTypeInfo = SignBDFactory.getLocalInstance(ctx).getSignBDInfo(new ObjectUuidPK(id));
			signTypeInfo.setBillStatus(UsedStatus.trueValue);
			SignBDFactory.getLocalInstance(ctx).save(signTypeInfo);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @operation
	 *
	 */
	@Override
	protected void _engProjectCancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
			EngProjectInfo Info = EngProjectFactory.getLocalInstance(ctx).getEngProjectInfo(new ObjectUuidPK(id));
			Info.setBillStatus(UsedStatus.falseValue);
			EngProjectFactory.getLocalInstance(ctx).save(Info);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @operation
	 *
	 */
	@Override
	protected void _engProjectCancelCancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
			EngProjectInfo Info = EngProjectFactory.getLocalInstance(ctx).getEngProjectInfo(new ObjectUuidPK(id));
			Info.setBillStatus(UsedStatus.trueValue);
			EngProjectFactory.getLocalInstance(ctx).save(Info);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @operation
	 *
	 */
	@Override
	protected void _cTypeCancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
		   ContractTypeInfo signTypeInfo = ContractTypeFactory.getLocalInstance(ctx).getContractTypeInfo(new ObjectUuidPK(id));
			signTypeInfo.setBillStatus(UsedStatus.falseValue);
			ContractTypeFactory.getLocalInstance(ctx).save(signTypeInfo);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @operation
	 *
	 */
	@Override
	protected void _cTypeCancelCancel(Context ctx, String id) throws BOSException {
		// TODO Auto-generated method stub
		try {
			   ContractTypeInfo signTypeInfo = ContractTypeFactory.getLocalInstance(ctx).getContractTypeInfo(new ObjectUuidPK(id));
				signTypeInfo.setBillStatus(UsedStatus.trueValue);
				ContractTypeFactory.getLocalInstance(ctx).save(signTypeInfo);
				
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}