package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CostAllocation extends CoreBillBase implements ICostAllocation
{
    public CostAllocation()
    {
        super();
        registerInterface(ICostAllocation.class, this);
    }
    public CostAllocation(Context ctx)
    {
        super(ctx);
        registerInterface(ICostAllocation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8337DD32");
    }
    private CostAllocationController getController() throws BOSException
    {
        return (CostAllocationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CostAllocationCollection getCostAllocationCollection() throws BOSException
    {
        try {
            return getController().getCostAllocationCollection(getContext());
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
    public CostAllocationCollection getCostAllocationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostAllocationCollection(getContext(), view);
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
    public CostAllocationCollection getCostAllocationCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostAllocationCollection(getContext(), oql);
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
    public CostAllocationInfo getCostAllocationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationInfo(getContext(), pk);
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
    public CostAllocationInfo getCostAllocationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationInfo(getContext(), pk, selector);
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
    public CostAllocationInfo getCostAllocationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CostAllocationInfo model) throws BOSException, EASBizException
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
    public void unAudit(CostAllocationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *分摊-User defined method
     *@param model model
     */
    public void exeAllocation(CostAllocationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().exeAllocation(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}