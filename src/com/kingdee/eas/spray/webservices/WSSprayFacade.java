package com.kingdee.eas.spray.webservices;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.spray.webservices.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSSprayFacade extends AbstractBizCtrl implements IWSSprayFacade
{
    public WSSprayFacade()
    {
        super();
        registerInterface(IWSSprayFacade.class, this);
    }
    public WSSprayFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSSprayFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0E3A2C09");
    }
    private WSSprayFacadeController getController() throws BOSException
    {
        return (WSSprayFacadeController)getBizController();
    }
    /**
     *[description]得到当前余额[%description][invokedemo][%invokedemo][returndesc]返回json结果[%returndesc]-User defined method
     *@param jsonStr 传入字符串
     *@return
     */
    public String getNowBalance(String jsonStr) throws BOSException
    {
        try {
            return getController().getNowBalance(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *上传使用明细-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String uploadUseRecord(String jsonStr) throws BOSException
    {
        try {
            return getController().uploadUseRecord(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}