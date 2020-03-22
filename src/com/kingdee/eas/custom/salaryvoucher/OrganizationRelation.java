package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salaryvoucher.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OrganizationRelation extends DataBase implements IOrganizationRelation
{
    public OrganizationRelation()
    {
        super();
        registerInterface(IOrganizationRelation.class, this);
    }
    public OrganizationRelation(Context ctx)
    {
        super(ctx);
        registerInterface(IOrganizationRelation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D616851E");
    }
    private OrganizationRelationController getController() throws BOSException
    {
        return (OrganizationRelationController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OrganizationRelationInfo getOrganizationRelationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOrganizationRelationInfo(getContext(), pk);
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
    public OrganizationRelationInfo getOrganizationRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOrganizationRelationInfo(getContext(), pk, selector);
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
    public OrganizationRelationInfo getOrganizationRelationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOrganizationRelationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OrganizationRelationCollection getOrganizationRelationCollection() throws BOSException
    {
        try {
            return getController().getOrganizationRelationCollection(getContext());
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
    public OrganizationRelationCollection getOrganizationRelationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOrganizationRelationCollection(getContext(), view);
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
    public OrganizationRelationCollection getOrganizationRelationCollection(String oql) throws BOSException
    {
        try {
            return getController().getOrganizationRelationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}