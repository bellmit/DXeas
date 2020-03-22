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
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class PaymentBillImportFacade extends AbstractBizCtrl implements IPaymentBillImportFacade
{
    public PaymentBillImportFacade()
    {
        super();
        registerInterface(IPaymentBillImportFacade.class, this);
    }
    public PaymentBillImportFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IPaymentBillImportFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8D73E0AC");
    }
    private PaymentBillImportFacadeController getController() throws BOSException
    {
        return (PaymentBillImportFacadeController)getBizController();
    }
    /**
     *导入付款单-User defined method
     *@param param 参数
     *@return
     */
    public HashMap importPaymentBill(HashMap param) throws BOSException, EASBizException
    {
        try {
            return getController().importPaymentBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}