package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompanyOwnBreedSet extends DataBase implements ICompanyOwnBreedSet
{
    public CompanyOwnBreedSet()
    {
        super();
        registerInterface(ICompanyOwnBreedSet.class, this);
    }
    public CompanyOwnBreedSet(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyOwnBreedSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FFA6F611");
    }
    private CompanyOwnBreedSetController getController() throws BOSException
    {
        return (CompanyOwnBreedSetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyOwnBreedSetInfo(getContext(), pk);
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
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyOwnBreedSetInfo(getContext(), pk, selector);
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
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyOwnBreedSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection() throws BOSException
    {
        try {
            return getController().getCompanyOwnBreedSetCollection(getContext());
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
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyOwnBreedSetCollection(getContext(), view);
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
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyOwnBreedSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}