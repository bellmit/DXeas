package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class CarcassFacade extends AbstractBizCtrl implements ICarcassFacade
{
    public CarcassFacade()
    {
        super();
        registerInterface(ICarcassFacade.class, this);
    }
    public CarcassFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICarcassFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B4B2D9D6");
    }
    private CarcassFacadeController getController() throws BOSException
    {
        return (CarcassFacadeController)getBizController();
    }
    /**
     *生成胴体接收单-User defined method
     *@param params 获取数据
     *@return
     */
    public String createBill(String params) throws BOSException
    {
        try {
            return getController().createBill(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}