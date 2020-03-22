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

public class PersonFarmerRelation extends DataBase implements IPersonFarmerRelation
{
    public PersonFarmerRelation()
    {
        super();
        registerInterface(IPersonFarmerRelation.class, this);
    }
    public PersonFarmerRelation(Context ctx)
    {
        super(ctx);
        registerInterface(IPersonFarmerRelation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("26BD9205");
    }
    private PersonFarmerRelationController getController() throws BOSException
    {
        return (PersonFarmerRelationController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PersonFarmerRelationInfo getPersonFarmerRelationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonFarmerRelationInfo(getContext(), pk);
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
    public PersonFarmerRelationInfo getPersonFarmerRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonFarmerRelationInfo(getContext(), pk, selector);
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
    public PersonFarmerRelationInfo getPersonFarmerRelationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonFarmerRelationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PersonFarmerRelationCollection getPersonFarmerRelationCollection() throws BOSException
    {
        try {
            return getController().getPersonFarmerRelationCollection(getContext());
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
    public PersonFarmerRelationCollection getPersonFarmerRelationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPersonFarmerRelationCollection(getContext(), view);
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
    public PersonFarmerRelationCollection getPersonFarmerRelationCollection(String oql) throws BOSException
    {
        try {
            return getController().getPersonFarmerRelationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(PersonFarmerRelationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(PersonFarmerRelationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}