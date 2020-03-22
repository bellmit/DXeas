package com.kingdee.eas.farm.feedfactory.app;

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
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import com.kingdee.eas.qm.basedata.QCStandardInfo;
import java.lang.String;



public abstract class AbstractQualityCheckFacadeControllerBean extends AbstractBizControllerBean implements QualityCheckFacadeController
{
    protected AbstractQualityCheckFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("051276A5");
    }

    public QCStandardInfo getMaterialCheckStandard(Context ctx, String checkOrgUnitID, String materialID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c60f48ad-a82e-41a1-8d5a-999dba45b6f8"), new Object[]{ctx, checkOrgUnitID, materialID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            QCStandardInfo retValue = (QCStandardInfo)_getMaterialCheckStandard(ctx, checkOrgUnitID, materialID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (QCStandardInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected QCStandardInfo _getMaterialCheckStandard(Context ctx, String checkOrgUnitID, String materialID) throws BOSException
    {    	
        return null;
    }

}