package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.mobileRPT.app.*;
import com.kingdee.bos.util.*;

public class mobileRPTFacade extends AbstractBizCtrl implements ImobileRPTFacade
{
    public mobileRPTFacade()
    {
        super();
        registerInterface(ImobileRPTFacade.class, this);
    }
    public mobileRPTFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ImobileRPTFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("00578DEF");
    }
    private mobileRPTFacadeController getController() throws BOSException
    {
        return (mobileRPTFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]JSON格式的字符串[%returndesc]-User defined method
     *@param param param
     *@return
     */
    public String getData(String param) throws BOSException
    {
        try {
            return getController().getData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]是否发送成功[%returndesc]-User defined method
     *@return
     */
    public boolean sendPRT() throws BOSException
    {
        try {
            return getController().sendPRT(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}