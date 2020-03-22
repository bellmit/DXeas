package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.runkanban.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class runKanbanFacade extends AbstractBizCtrl implements IrunKanbanFacade
{
    public runKanbanFacade()
    {
        super();
        registerInterface(IrunKanbanFacade.class, this);
    }
    public runKanbanFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IrunKanbanFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3CF833AB");
    }
    private runKanbanFacadeController getController() throws BOSException
    {
        return (runKanbanFacadeController)getBizController();
    }
    /**
     *通过json参数获取数据-User defined method
     *@param query json类型
     *@return
     */
    public String getDataFromJsonCondition(String query) throws BOSException
    {
        try {
            return getController().getDataFromJsonCondition(getContext(), query);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}