package com.kingdee.eas.custom.taihe.settle;

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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.eas.custom.taihe.settle.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TaiHeSettlePolicy extends WlhlDataBase implements ITaiHeSettlePolicy
{
    public TaiHeSettlePolicy()
    {
        super();
        registerInterface(ITaiHeSettlePolicy.class, this);
    }
    public TaiHeSettlePolicy(Context ctx)
    {
        super(ctx);
        registerInterface(ITaiHeSettlePolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E6F5C1D3");
    }
    private TaiHeSettlePolicyController getController() throws BOSException
    {
        return (TaiHeSettlePolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiHeSettlePolicyInfo(getContext(), pk);
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
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiHeSettlePolicyInfo(getContext(), pk, selector);
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
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiHeSettlePolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection() throws BOSException
    {
        try {
            return getController().getTaiHeSettlePolicyCollection(getContext());
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
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTaiHeSettlePolicyCollection(getContext(), view);
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
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getTaiHeSettlePolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}