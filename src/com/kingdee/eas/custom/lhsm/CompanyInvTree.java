package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.eas.custom.lhsm.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompanyInvTree extends TreeBase implements ICompanyInvTree
{
    public CompanyInvTree()
    {
        super();
        registerInterface(ICompanyInvTree.class, this);
    }
    public CompanyInvTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyInvTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7F4CC09F");
    }
    private CompanyInvTreeController getController() throws BOSException
    {
        return (CompanyInvTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyInvTreeInfo getCompanyInvTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvTreeInfo(getContext(), pk);
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
    public CompanyInvTreeInfo getCompanyInvTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvTreeInfo(getContext(), pk, selector);
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
    public CompanyInvTreeInfo getCompanyInvTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyInvTreeCollection getCompanyInvTreeCollection() throws BOSException
    {
        try {
            return getController().getCompanyInvTreeCollection(getContext());
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
    public CompanyInvTreeCollection getCompanyInvTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyInvTreeCollection(getContext(), view);
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
    public CompanyInvTreeCollection getCompanyInvTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyInvTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}