package com.kingdee.eas.custom.taihe.door;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.door.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class DoorWsFacade extends AbstractBizCtrl implements IDoorWsFacade
{
    public DoorWsFacade()
    {
        super();
        registerInterface(IDoorWsFacade.class, this);
    }
    public DoorWsFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDoorWsFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("19DD97E4");
    }
    private DoorWsFacadeController getController() throws BOSException
    {
        return (DoorWsFacadeController)getBizController();
    }
    /**
     *—È÷§-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String verify(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().verify(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}