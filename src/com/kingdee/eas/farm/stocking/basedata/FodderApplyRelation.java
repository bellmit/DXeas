package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FodderApplyRelation extends DataBase implements IFodderApplyRelation
{
    public FodderApplyRelation()
    {
        super();
        registerInterface(IFodderApplyRelation.class, this);
    }
    public FodderApplyRelation(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderApplyRelation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8297D2C3");
    }
    private FodderApplyRelationController getController() throws BOSException
    {
        return (FodderApplyRelationController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FodderApplyRelationInfo getFodderApplyRelationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyRelationInfo(getContext(), pk);
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
    public FodderApplyRelationInfo getFodderApplyRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyRelationInfo(getContext(), pk, selector);
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
    public FodderApplyRelationInfo getFodderApplyRelationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyRelationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FodderApplyRelationCollection getFodderApplyRelationCollection() throws BOSException
    {
        try {
            return getController().getFodderApplyRelationCollection(getContext());
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
    public FodderApplyRelationCollection getFodderApplyRelationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderApplyRelationCollection(getContext(), view);
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
    public FodderApplyRelationCollection getFodderApplyRelationCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderApplyRelationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}