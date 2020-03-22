package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.stocount.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class SemiCountOperateFacade extends AbstractBizCtrl implements ISemiCountOperateFacade
{
    public SemiCountOperateFacade()
    {
        super();
        registerInterface(ISemiCountOperateFacade.class, this);
    }
    public SemiCountOperateFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISemiCountOperateFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4B9DE17A");
    }
    private SemiCountOperateFacadeController getController() throws BOSException
    {
        return (SemiCountOperateFacadeController)getBizController();
    }
    /**
     *半成品计数判断-User defined method
     *@param personid 用户ID
     *@return
     */
    public HashMap semiset(String personid) throws BOSException
    {
        try {
            return getController().semiset(getContext(), personid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *成品岗位判断-User defined method
     *@param personid 用户ID
     *@return
     */
    public HashMap productset(String personid) throws BOSException
    {
        try {
            return getController().productset(getContext(), personid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}