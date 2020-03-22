package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MyTest extends CoreBillBase implements IMyTest
{
    public MyTest()
    {
        super();
        registerInterface(IMyTest.class, this);
    }
    public MyTest(Context ctx)
    {
        super(ctx);
        registerInterface(IMyTest.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8B4D60B4");
    }
    private MyTestController getController() throws BOSException
    {
        return (MyTestController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MyTestCollection getMyTestCollection() throws BOSException
    {
        try {
            return getController().getMyTestCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public MyTestCollection getMyTestCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMyTestCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public MyTestCollection getMyTestCollection(String oql) throws BOSException
    {
        try {
            return getController().getMyTestCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MyTestInfo getMyTestInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMyTestInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public MyTestInfo getMyTestInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMyTestInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public MyTestInfo getMyTestInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMyTestInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}