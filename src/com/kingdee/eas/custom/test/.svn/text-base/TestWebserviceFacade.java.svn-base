package com.kingdee.eas.custom.test;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.test.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class TestWebserviceFacade extends AbstractBizCtrl implements ITestWebserviceFacade
{
    public TestWebserviceFacade()
    {
        super();
        registerInterface(ITestWebserviceFacade.class, this);
    }
    public TestWebserviceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ITestWebserviceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("47C9643E");
    }
    private TestWebserviceFacadeController getController() throws BOSException
    {
        return (TestWebserviceFacadeController)getBizController();
    }
    /**
     *获取数据-User defined method
     *@param jsonStr json字符
     *@return
     */
    public String getData(String jsonStr) throws BOSException
    {
        try {
            return getController().getData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}