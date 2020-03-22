package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class BusinessDailyFacade extends AbstractBizCtrl implements IBusinessDailyFacade
{
    public BusinessDailyFacade()
    {
        super();
        registerInterface(IBusinessDailyFacade.class, this);
    }
    public BusinessDailyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBusinessDailyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("72E04711");
    }
    private BusinessDailyFacadeController getController() throws BOSException
    {
        return (BusinessDailyFacadeController)getBizController();
    }
}