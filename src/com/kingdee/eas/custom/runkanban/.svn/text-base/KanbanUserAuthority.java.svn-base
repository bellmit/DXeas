package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.runkanban.app.*;
import com.kingdee.bos.BOSException;
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

public class KanbanUserAuthority extends CoreBillBase implements IKanbanUserAuthority
{
    public KanbanUserAuthority()
    {
        super();
        registerInterface(IKanbanUserAuthority.class, this);
    }
    public KanbanUserAuthority(Context ctx)
    {
        super(ctx);
        registerInterface(IKanbanUserAuthority.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("552FA0F0");
    }
    private KanbanUserAuthorityController getController() throws BOSException
    {
        return (KanbanUserAuthorityController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection() throws BOSException
    {
        try {
            return getController().getKanbanUserAuthorityCollection(getContext());
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
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getKanbanUserAuthorityCollection(getContext(), view);
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
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection(String oql) throws BOSException
    {
        try {
            return getController().getKanbanUserAuthorityCollection(getContext(), oql);
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
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getKanbanUserAuthorityInfo(getContext(), pk);
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
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getKanbanUserAuthorityInfo(getContext(), pk, selector);
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
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getKanbanUserAuthorityInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}