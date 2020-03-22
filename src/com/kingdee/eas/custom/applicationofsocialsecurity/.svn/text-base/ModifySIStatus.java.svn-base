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

public class ModifySIStatus extends CoreBillBase implements IModifySIStatus
{
    public ModifySIStatus()
    {
        super();
        registerInterface(IModifySIStatus.class, this);
    }
    public ModifySIStatus(Context ctx)
    {
        super(ctx);
        registerInterface(IModifySIStatus.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E6B2A5C1");
    }
    private ModifySIStatusController getController() throws BOSException
    {
        return (ModifySIStatusController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ModifySIStatusCollection getModifySIStatusCollection() throws BOSException
    {
        try {
            return getController().getModifySIStatusCollection(getContext());
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
    public ModifySIStatusCollection getModifySIStatusCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getModifySIStatusCollection(getContext(), view);
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
    public ModifySIStatusCollection getModifySIStatusCollection(String oql) throws BOSException
    {
        try {
            return getController().getModifySIStatusCollection(getContext(), oql);
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
    public ModifySIStatusInfo getModifySIStatusInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusInfo(getContext(), pk);
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
    public ModifySIStatusInfo getModifySIStatusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusInfo(getContext(), pk, selector);
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
    public ModifySIStatusInfo getModifySIStatusInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *撤销全部-User defined method
     *@param model model
     */
    public void undoAll(ModifySIStatusInfo model) throws BOSException
    {
        try {
            getController().undoAll(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *撤销选中-User defined method
     *@param model model
     */
    public void undoSelected(ModifySIStatusInfo model) throws BOSException
    {
        try {
            getController().undoSelected(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}