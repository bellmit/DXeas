package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.qm.basedata.QCStandardInfo;
import com.kingdee.eas.farm.feedfactory.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class QualityCheckFacade extends AbstractBizCtrl implements IQualityCheckFacade
{
    public QualityCheckFacade()
    {
        super();
        registerInterface(IQualityCheckFacade.class, this);
    }
    public QualityCheckFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IQualityCheckFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("051276A5");
    }
    private QualityCheckFacadeController getController() throws BOSException
    {
        return (QualityCheckFacadeController)getBizController();
    }
    /**
     *获取物料的质检标准-User defined method
     *@param checkOrgUnitID 质检组织ID
     *@param materialID 物料ID
     *@return
     */
    public QCStandardInfo getMaterialCheckStandard(String checkOrgUnitID, String materialID) throws BOSException
    {
        try {
            return getController().getMaterialCheckStandard(getContext(), checkOrgUnitID, materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}