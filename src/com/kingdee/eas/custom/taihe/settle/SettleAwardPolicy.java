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

public class SettleAwardPolicy extends WlhlDataBase implements ISettleAwardPolicy
{
    public SettleAwardPolicy()
    {
        super();
        registerInterface(ISettleAwardPolicy.class, this);
    }
    public SettleAwardPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleAwardPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("013226C1");
    }
    private SettleAwardPolicyController getController() throws BOSException
    {
        return (SettleAwardPolicyController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SettleAwardPolicyInfo getSettleAwardPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleAwardPolicyInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public SettleAwardPolicyInfo getSettleAwardPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleAwardPolicyInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public SettleAwardPolicyInfo getSettleAwardPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleAwardPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SettleAwardPolicyCollection getSettleAwardPolicyCollection() throws BOSException
    {
        try {
            return getController().getSettleAwardPolicyCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public SettleAwardPolicyCollection getSettleAwardPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettleAwardPolicyCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public SettleAwardPolicyCollection getSettleAwardPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettleAwardPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}