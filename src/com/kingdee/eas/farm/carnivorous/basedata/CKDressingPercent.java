package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
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

public class CKDressingPercent extends DataBase implements ICKDressingPercent
{
    public CKDressingPercent()
    {
        super();
        registerInterface(ICKDressingPercent.class, this);
    }
    public CKDressingPercent(Context ctx)
    {
        super(ctx);
        registerInterface(ICKDressingPercent.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("23BB4CB0");
    }
    private CKDressingPercentController getController() throws BOSException
    {
        return (CKDressingPercentController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CKDressingPercentInfo getCKDressingPercentInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKDressingPercentInfo(getContext(), pk);
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
    public CKDressingPercentInfo getCKDressingPercentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKDressingPercentInfo(getContext(), pk, selector);
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
    public CKDressingPercentInfo getCKDressingPercentInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKDressingPercentInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKDressingPercentCollection getCKDressingPercentCollection() throws BOSException
    {
        try {
            return getController().getCKDressingPercentCollection(getContext());
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
    public CKDressingPercentCollection getCKDressingPercentCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKDressingPercentCollection(getContext(), view);
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
    public CKDressingPercentCollection getCKDressingPercentCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKDressingPercentCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(CKDressingPercentInfo model) throws BOSException, EASBizException
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
    public void unAudit(CKDressingPercentInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}