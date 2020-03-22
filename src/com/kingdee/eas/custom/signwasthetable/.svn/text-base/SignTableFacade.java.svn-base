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

public class SignTableFacade extends AbstractBizCtrl implements ISignTableFacade
{
    public SignTableFacade()
    {
        super();
        registerInterface(ISignTableFacade.class, this);
    }
    public SignTableFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISignTableFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("443417C1");
    }
    private SignTableFacadeController getController() throws BOSException
    {
        return (SignTableFacadeController)getBizController();
    }
    /**
     *getdepartment-User defined method
     *@param prePerson ≥ ÀÕ’ﬂ
     *@return
     */
    public String getdepartment(String prePerson) throws BOSException
    {
        try {
            return getController().getdepartment(getContext(), prePerson);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}