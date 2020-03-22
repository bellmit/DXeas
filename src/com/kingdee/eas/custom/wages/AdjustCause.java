package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AdjustCause extends DataBase implements IAdjustCause
{
    public AdjustCause()
    {
        super();
        registerInterface(IAdjustCause.class, this);
    }
    public AdjustCause(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustCause.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E5317D12");
    }
    private AdjustCauseController getController() throws BOSException
    {
        return (AdjustCauseController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AdjustCauseInfo getAdjustCauseInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseInfo(getContext(), pk);
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
    public AdjustCauseInfo getAdjustCauseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseInfo(getContext(), pk, selector);
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
    public AdjustCauseInfo getAdjustCauseInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustCauseInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustCauseCollection getAdjustCauseCollection() throws BOSException
    {
        try {
            return getController().getAdjustCauseCollection(getContext());
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
    public AdjustCauseCollection getAdjustCauseCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustCauseCollection(getContext(), view);
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
    public AdjustCauseCollection getAdjustCauseCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustCauseCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}