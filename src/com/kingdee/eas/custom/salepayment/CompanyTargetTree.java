package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompanyTargetTree extends TreeBase implements ICompanyTargetTree
{
    public CompanyTargetTree()
    {
        super();
        registerInterface(ICompanyTargetTree.class, this);
    }
    public CompanyTargetTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyTargetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AF4D80B8");
    }
    private CompanyTargetTreeController getController() throws BOSException
    {
        return (CompanyTargetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyTargetTreeInfo getCompanyTargetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetTreeInfo(getContext(), pk);
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
    public CompanyTargetTreeInfo getCompanyTargetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetTreeInfo(getContext(), pk, selector);
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
    public CompanyTargetTreeInfo getCompanyTargetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyTargetTreeCollection getCompanyTargetTreeCollection() throws BOSException
    {
        try {
            return getController().getCompanyTargetTreeCollection(getContext());
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
    public CompanyTargetTreeCollection getCompanyTargetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyTargetTreeCollection(getContext(), view);
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
    public CompanyTargetTreeCollection getCompanyTargetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyTargetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}