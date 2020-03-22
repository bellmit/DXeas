package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.ccchargeback.app.*;
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

public class ChargeBackStd extends DataBase implements IChargeBackStd
{
    public ChargeBackStd()
    {
        super();
        registerInterface(IChargeBackStd.class, this);
    }
    public ChargeBackStd(Context ctx)
    {
        super(ctx);
        registerInterface(IChargeBackStd.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6E4B5E00");
    }
    private ChargeBackStdController getController() throws BOSException
    {
        return (ChargeBackStdController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ChargeBackStdInfo getChargeBackStdInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChargeBackStdInfo(getContext(), pk);
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
    public ChargeBackStdInfo getChargeBackStdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChargeBackStdInfo(getContext(), pk, selector);
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
    public ChargeBackStdInfo getChargeBackStdInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChargeBackStdInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChargeBackStdCollection getChargeBackStdCollection() throws BOSException
    {
        try {
            return getController().getChargeBackStdCollection(getContext());
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
    public ChargeBackStdCollection getChargeBackStdCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChargeBackStdCollection(getContext(), view);
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
    public ChargeBackStdCollection getChargeBackStdCollection(String oql) throws BOSException
    {
        try {
            return getController().getChargeBackStdCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ChargeBackStdInfo model) throws BOSException, EASBizException
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
    public void unAudit(ChargeBackStdInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}