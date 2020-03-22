package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.breed.brood.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class BroodDailyFacade extends AbstractBizCtrl implements IBroodDailyFacade
{
    public BroodDailyFacade()
    {
        super();
        registerInterface(IBroodDailyFacade.class, this);
    }
    public BroodDailyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBroodDailyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("29FD5053");
    }
    private BroodDailyFacadeController getController() throws BOSException
    {
        return (BroodDailyFacadeController)getBizController();
    }
    /**
     *根据鸡舍获取对应的 育成鸡舍设置-User defined method
     *@param henhouseID 鸡舍id
     *@return
     */
    public Object getBroodCoopSet(String henhouseID) throws BOSException
    {
        try {
            return getController().getBroodCoopSet(getContext(), henhouseID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}