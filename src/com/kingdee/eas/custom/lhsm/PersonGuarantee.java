package com.kingdee.eas.custom.lhsm;

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
import com.kingdee.eas.custom.lhsm.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonGuarantee extends DataBase implements IPersonGuarantee
{
    public PersonGuarantee()
    {
        super();
        registerInterface(IPersonGuarantee.class, this);
    }
    public PersonGuarantee(Context ctx)
    {
        super(ctx);
        registerInterface(IPersonGuarantee.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3B72EBA6");
    }
    private PersonGuaranteeController getController() throws BOSException
    {
        return (PersonGuaranteeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PersonGuaranteeInfo getPersonGuaranteeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonGuaranteeInfo(getContext(), pk);
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
    public PersonGuaranteeInfo getPersonGuaranteeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonGuaranteeInfo(getContext(), pk, selector);
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
    public PersonGuaranteeInfo getPersonGuaranteeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonGuaranteeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PersonGuaranteeCollection getPersonGuaranteeCollection() throws BOSException
    {
        try {
            return getController().getPersonGuaranteeCollection(getContext());
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
    public PersonGuaranteeCollection getPersonGuaranteeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPersonGuaranteeCollection(getContext(), view);
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
    public PersonGuaranteeCollection getPersonGuaranteeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPersonGuaranteeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}