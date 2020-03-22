package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.util.*;

public class TecrecordFacade extends AbstractBizCtrl implements ITecrecordFacade
{
    public TecrecordFacade()
    {
        super();
        registerInterface(ITecrecordFacade.class, this);
    }
    public TecrecordFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ITecrecordFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("334DEB58");
    }
    private TecrecordFacadeController getController() throws BOSException
    {
        return (TecrecordFacadeController)getBizController();
    }
    /**
     *获取数据-User defined method
     *@param jsonStr json字符串
     *@return
     */
    public long getData(String jsonStr) throws BOSException
    {
        try {
            return getController().getData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}