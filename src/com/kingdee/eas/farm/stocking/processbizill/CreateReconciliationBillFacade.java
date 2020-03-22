package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CreateReconciliationBillFacade extends AbstractBizCtrl implements ICreateReconciliationBillFacade
{
    public CreateReconciliationBillFacade()
    {
        super();
        registerInterface(ICreateReconciliationBillFacade.class, this);
    }
    public CreateReconciliationBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICreateReconciliationBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F4409C85");
    }
    private CreateReconciliationBillFacadeController getController() throws BOSException
    {
        return (CreateReconciliationBillFacadeController)getBizController();
    }
    /**
     *生成对账单-User defined method
     *@param param 参数
     *@return
     */
    public HashMap CreateReconciliationBill(Map param) throws BOSException, EASBizException
    {
        try {
            return getController().CreateReconciliationBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *结转对账单-User defined method
     *@param param 参数
     *@return
     */
    public String CarryoverSettleBill(String param) throws BOSException
    {
        try {
            return getController().CarryoverSettleBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}