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

public class THWgtFacade extends AbstractBizCtrl implements ITHWgtFacade
{
    public THWgtFacade()
    {
        super();
        registerInterface(ITHWgtFacade.class, this);
    }
    public THWgtFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ITHWgtFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("67ECC974");
    }
    private THWgtFacadeController getController() throws BOSException
    {
        return (THWgtFacadeController)getBizController();
    }
    /**
     *上传过磅信息-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String updateWgtInfo(String jsonStr) throws BOSException
    {
        try {
            return getController().updateWgtInfo(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}