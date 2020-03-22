package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.commonld.app.*;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CommFacade extends AbstractBizCtrl implements ICommFacade
{
    public CommFacade()
    {
        super();
        registerInterface(ICommFacade.class, this);
    }
    public CommFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICommFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FE85DA86");
    }
    private CommFacadeController getController() throws BOSException
    {
        return (CommFacadeController)getBizController();
    }
    /**
     *执行一段更新语句-User defined method
     *@param str sql语句
     */
    public void excuteUpdateSql(String str) throws BOSException, EASBizException
    {
        try {
            getController().excuteUpdateSql(getContext(), str);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取服务器时间-User defined method
     *@return
     */
    public Date getDateFromServer() throws BOSException
    {
        try {
            return getController().getDateFromServer(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}