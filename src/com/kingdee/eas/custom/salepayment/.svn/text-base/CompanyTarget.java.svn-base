package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompanyTarget extends DataBase implements ICompanyTarget
{
    public CompanyTarget()
    {
        super();
        registerInterface(ICompanyTarget.class, this);
    }
    public CompanyTarget(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyTarget.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1E7D25FA");
    }
    private CompanyTargetController getController() throws BOSException
    {
        return (CompanyTargetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyTargetInfo getCompanyTargetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetInfo(getContext(), pk);
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
    public CompanyTargetInfo getCompanyTargetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetInfo(getContext(), pk, selector);
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
    public CompanyTargetInfo getCompanyTargetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyTargetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyTargetCollection getCompanyTargetCollection() throws BOSException
    {
        try {
            return getController().getCompanyTargetCollection(getContext());
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
    public CompanyTargetCollection getCompanyTargetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyTargetCollection(getContext(), view);
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
    public CompanyTargetCollection getCompanyTargetCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyTargetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CompanyTargetInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(CompanyTargetInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}