package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class saveRealTimeInventoryFacade extends AbstractBizCtrl implements IsaveRealTimeInventoryFacade
{
    public saveRealTimeInventoryFacade()
    {
        super();
        registerInterface(IsaveRealTimeInventoryFacade.class, this);
    }
    public saveRealTimeInventoryFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsaveRealTimeInventoryFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D0D4637E");
    }
    private saveRealTimeInventoryFacadeController getController() throws BOSException
    {
        return (saveRealTimeInventoryFacadeController)getBizController();
    }
    /**
     *保存当日的即时库存-User defined method
     */
    public void saveRealTimeInventory() throws BOSException
    {
        try {
            getController().saveRealTimeInventory(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *保存物料基本价格-User defined method
     */
    public void saveMaterialBasePrice() throws BOSException
    {
        try {
            getController().saveMaterialBasePrice(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}