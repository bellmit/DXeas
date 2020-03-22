package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.wlhlcomm.function.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class BillUpdateFacade extends AbstractBizCtrl implements IBillUpdateFacade
{
    public BillUpdateFacade()
    {
        super();
        registerInterface(IBillUpdateFacade.class, this);
    }
    public BillUpdateFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBillUpdateFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("84778989");
    }
    private BillUpdateFacadeController getController() throws BOSException
    {
        return (BillUpdateFacadeController)getBizController();
    }
    /**
     *获得用户可以更新的单据列表-User defined method
     *@param userID userID
     *@return
     */
    public List getUserCanEditBills(String userID) throws BOSException
    {
        try {
            return getController().getUserCanEditBills(getContext(), userID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取单据可编辑字段-User defined method
     *@param editBillID editBillID
     *@return
     */
    public Map getBillEidtFields(String editBillID) throws BOSException
    {
        try {
            return getController().getBillEidtFields(getContext(), editBillID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}