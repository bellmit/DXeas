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

public class CompanyInv extends DataBase implements ICompanyInv
{
    public CompanyInv()
    {
        super();
        registerInterface(ICompanyInv.class, this);
    }
    public CompanyInv(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyInv.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("286E7161");
    }
    private CompanyInvController getController() throws BOSException
    {
        return (CompanyInvController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyInvInfo getCompanyInvInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvInfo(getContext(), pk);
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
    public CompanyInvInfo getCompanyInvInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvInfo(getContext(), pk, selector);
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
    public CompanyInvInfo getCompanyInvInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyInvInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyInvCollection getCompanyInvCollection() throws BOSException
    {
        try {
            return getController().getCompanyInvCollection(getContext());
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
    public CompanyInvCollection getCompanyInvCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyInvCollection(getContext(), view);
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
    public CompanyInvCollection getCompanyInvCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyInvCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}