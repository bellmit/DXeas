package com.kingdee.eas.custom.festival;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.festival.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ManufactureRecBillNewFacade extends AbstractBizCtrl implements IManufactureRecBillNewFacade
{
    public ManufactureRecBillNewFacade()
    {
        super();
        registerInterface(IManufactureRecBillNewFacade.class, this);
    }
    public ManufactureRecBillNewFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IManufactureRecBillNewFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("67D94759");
    }
    private ManufactureRecBillNewFacadeController getController() throws BOSException
    {
        return (ManufactureRecBillNewFacadeController)getBizController();
    }
    /**
     *importData-User defined method
     *@param xml xml
     *@return
     */
    public String[] importData(String xml) throws BOSException
    {
        try {
            return getController().importData(getContext(), xml);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}