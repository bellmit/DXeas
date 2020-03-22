package com.kingdee.eas.farm.pig.ccpig;

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
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCPigBatch extends CoreBillBase implements ICCPigBatch
{
    public CCPigBatch()
    {
        super();
        registerInterface(ICCPigBatch.class, this);
    }
    public CCPigBatch(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigBatch.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BFBD736C");
    }
    private CCPigBatchController getController() throws BOSException
    {
        return (CCPigBatchController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCPigBatchCollection getCCPigBatchCollection() throws BOSException
    {
        try {
            return getController().getCCPigBatchCollection(getContext());
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
    public CCPigBatchCollection getCCPigBatchCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCPigBatchCollection(getContext(), view);
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
    public CCPigBatchCollection getCCPigBatchCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCPigBatchCollection(getContext(), oql);
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
    public CCPigBatchInfo getCCPigBatchInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchInfo(getContext(), pk);
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
    public CCPigBatchInfo getCCPigBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchInfo(getContext(), pk, selector);
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
    public CCPigBatchInfo getCCPigBatchInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBatchInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CCPigBatchInfo model) throws BOSException
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
    public void unAudit(CCPigBatchInfo model) throws BOSException
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
    public void updateBatchMarket(CCPigBatchInfo model) throws BOSException
    {
        try {
            getController().updateBatchMarket(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}