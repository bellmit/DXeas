package com.kingdee.eas.custom.test;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.custom.test.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Signwasthetable extends CoreBillBase implements ISignwasthetable
{
    public Signwasthetable()
    {
        super();
        registerInterface(ISignwasthetable.class, this);
    }
    public Signwasthetable(Context ctx)
    {
        super(ctx);
        registerInterface(ISignwasthetable.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("747820B8");
    }
    private SignwasthetableController getController() throws BOSException
    {
        return (SignwasthetableController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SignwasthetableCollection getSignwasthetableCollection() throws BOSException
    {
        try {
            return getController().getSignwasthetableCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public SignwasthetableCollection getSignwasthetableCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSignwasthetableCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public SignwasthetableCollection getSignwasthetableCollection(String oql) throws BOSException
    {
        try {
            return getController().getSignwasthetableCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SignwasthetableInfo getSignwasthetableInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSignwasthetableInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public SignwasthetableInfo getSignwasthetableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSignwasthetableInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public SignwasthetableInfo getSignwasthetableInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSignwasthetableInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void check(SignwasthetableInfo model) throws BOSException
    {
        try {
            getController().check(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ɾ����-User defined method
     *@param model model
     */
    public void deleteLine(SignwasthetableInfo model) throws BOSException
    {
        try {
            getController().deleteLine(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param model model
     */
    public void listener(SignwasthetableInfo model) throws BOSException
    {
        try {
            getController().listener(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(SignwasthetableInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ˢ��-User defined method
     *@param model model
     */
    public void btnRefresh(SignwasthetableInfo model) throws BOSException
    {
        try {
            getController().btnRefresh(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}