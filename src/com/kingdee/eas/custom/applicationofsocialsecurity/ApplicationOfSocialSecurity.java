package com.kingdee.eas.custom.applicationofsocialsecurity;

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
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ApplicationOfSocialSecurity extends CoreBillBase implements IApplicationOfSocialSecurity
{
    public ApplicationOfSocialSecurity()
    {
        super();
        registerInterface(IApplicationOfSocialSecurity.class, this);
    }
    public ApplicationOfSocialSecurity(Context ctx)
    {
        super(ctx);
        registerInterface(IApplicationOfSocialSecurity.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("49DFE635");
    }
    private ApplicationOfSocialSecurityController getController() throws BOSException
    {
        return (ApplicationOfSocialSecurityController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection() throws BOSException
    {
        try {
            return getController().getApplicationOfSocialSecurityCollection(getContext());
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
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getApplicationOfSocialSecurityCollection(getContext(), view);
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
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(String oql) throws BOSException
    {
        try {
            return getController().getApplicationOfSocialSecurityCollection(getContext(), oql);
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
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getApplicationOfSocialSecurityInfo(getContext(), pk);
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
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getApplicationOfSocialSecurityInfo(getContext(), pk, selector);
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
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getApplicationOfSocialSecurityInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException
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
    public void unAudit(ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *设置社保状态-User defined method
     *@param model model
     */
    public void setSIStatus(ApplicationOfSocialSecurityInfo model) throws BOSException
    {
        try {
            getController().setSIStatus(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}