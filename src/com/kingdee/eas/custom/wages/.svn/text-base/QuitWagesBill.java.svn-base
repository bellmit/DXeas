package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class QuitWagesBill extends WlhlDataBase implements IQuitWagesBill
{
    public QuitWagesBill()
    {
        super();
        registerInterface(IQuitWagesBill.class, this);
    }
    public QuitWagesBill(Context ctx)
    {
        super(ctx);
        registerInterface(IQuitWagesBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CA63A65B");
    }
    private QuitWagesBillController getController() throws BOSException
    {
        return (QuitWagesBillController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public QuitWagesBillInfo getQuitWagesBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQuitWagesBillInfo(getContext(), pk);
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
    public QuitWagesBillInfo getQuitWagesBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQuitWagesBillInfo(getContext(), pk, selector);
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
    public QuitWagesBillInfo getQuitWagesBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQuitWagesBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QuitWagesBillCollection getQuitWagesBillCollection() throws BOSException
    {
        try {
            return getController().getQuitWagesBillCollection(getContext());
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
    public QuitWagesBillCollection getQuitWagesBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQuitWagesBillCollection(getContext(), view);
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
    public QuitWagesBillCollection getQuitWagesBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getQuitWagesBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}