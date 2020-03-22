package com.kingdee.eas.farm.pig;

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
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigBatch extends CoreBillBase implements IPigBatch
{
    public PigBatch()
    {
        super();
        registerInterface(IPigBatch.class, this);
    }
    public PigBatch(Context ctx)
    {
        super(ctx);
        registerInterface(IPigBatch.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FEF6F88C");
    }
    private PigBatchController getController() throws BOSException
    {
        return (PigBatchController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigBatchCollection getPigBatchCollection() throws BOSException
    {
        try {
            return getController().getPigBatchCollection(getContext());
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
    public PigBatchCollection getPigBatchCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigBatchCollection(getContext(), view);
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
    public PigBatchCollection getPigBatchCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigBatchCollection(getContext(), oql);
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
    public PigBatchInfo getPigBatchInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchInfo(getContext(), pk);
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
    public PigBatchInfo getPigBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchInfo(getContext(), pk, selector);
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
    public PigBatchInfo getPigBatchInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(PigBatchInfo model) throws BOSException
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
    public void unAudit(PigBatchInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新分录出栏状态-User defined method
     *@param model model
     */
    public void updateBatchMarket(PigBatchInfo model) throws BOSException
    {
        try {
            getController().updateBatchMarket(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}