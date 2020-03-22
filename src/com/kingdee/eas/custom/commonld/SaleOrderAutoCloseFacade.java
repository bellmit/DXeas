package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.commonld.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class SaleOrderAutoCloseFacade extends AbstractBizCtrl implements ISaleOrderAutoCloseFacade
{
    public SaleOrderAutoCloseFacade()
    {
        super();
        registerInterface(ISaleOrderAutoCloseFacade.class, this);
    }
    public SaleOrderAutoCloseFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleOrderAutoCloseFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DAC344FC");
    }
    private SaleOrderAutoCloseFacadeController getController() throws BOSException
    {
        return (SaleOrderAutoCloseFacadeController)getBizController();
    }
    /**
     *关闭过期销售订单-User defined method
     */
    public void closeSaleOrder() throws BOSException, EASBizException
    {
        try {
            getController().closeSaleOrder(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}