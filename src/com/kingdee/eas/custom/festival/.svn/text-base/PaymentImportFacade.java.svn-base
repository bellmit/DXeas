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

public class PaymentImportFacade extends AbstractBizCtrl implements IPaymentImportFacade
{
    public PaymentImportFacade()
    {
        super();
        registerInterface(IPaymentImportFacade.class, this);
    }
    public PaymentImportFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IPaymentImportFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BD56BFDA");
    }
    private PaymentImportFacadeController getController() throws BOSException
    {
        return (PaymentImportFacadeController)getBizController();
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