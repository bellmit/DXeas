package com.kingdee.eas.custom.weightPlatform;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.weightPlatform.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class WeightPlatformFacade extends AbstractBizCtrl implements IWeightPlatformFacade
{
    public WeightPlatformFacade()
    {
        super();
        registerInterface(IWeightPlatformFacade.class, this);
    }
    public WeightPlatformFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWeightPlatformFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("16C6C7DD");
    }
    private WeightPlatformFacadeController getController() throws BOSException
    {
        return (WeightPlatformFacadeController)getBizController();
    }
    /**
     *插入或更新过磅信息-User defined method
     *@param param param
     *@return
     */
    public String insertOrUpdateWeightInfo(Object param) throws BOSException, EASBizException
    {
        try {
            return getController().insertOrUpdateWeightInfo(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getWeightInfo-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getWeightInfo(String jsonStr) throws BOSException
    {
        try {
            return getController().getWeightInfo(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}