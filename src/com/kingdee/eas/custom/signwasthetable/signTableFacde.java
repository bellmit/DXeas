package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.bos.util.*;

public class signTableFacde extends AbstractBizCtrl implements IsignTableFacde
{
    public signTableFacde()
    {
        super();
        registerInterface(IsignTableFacde.class, this);
    }
    public signTableFacde(Context ctx)
    {
        super(ctx);
        registerInterface(IsignTableFacde.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6736C162");
    }
    private signTableFacdeController getController() throws BOSException
    {
        return (signTableFacdeController)getBizController();
    }
    /**
     *判断的单据是否处于工作流中-User defined method
     *@param billId 单据id
     *@return
     */
    public boolean isInWorkFlow(String billId) throws BOSException
    {
        try {
            return getController().isInWorkFlow(getContext(), billId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}