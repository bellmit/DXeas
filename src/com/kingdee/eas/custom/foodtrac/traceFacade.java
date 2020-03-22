package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.foodtrac.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class traceFacade extends AbstractBizCtrl implements ItraceFacade
{
    public traceFacade()
    {
        super();
        registerInterface(ItraceFacade.class, this);
    }
    public traceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ItraceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F01DB07A");
    }
    private traceFacadeController getController() throws BOSException
    {
        return (traceFacadeController)getBizController();
    }
    /**
     *根据json条件获取数据-User defined method
     *@param queryStr json格式的字符串
     *@return
     */
    public String getDataFromJsonCondition(String queryStr) throws BOSException
    {
        try {
            return getController().getDataFromJsonCondition(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}