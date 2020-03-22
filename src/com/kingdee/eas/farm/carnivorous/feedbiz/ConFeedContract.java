package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ConFeedContract extends CoreBillBase implements IConFeedContract
{
    public ConFeedContract()
    {
        super();
        registerInterface(IConFeedContract.class, this);
    }
    public ConFeedContract(Context ctx)
    {
        super(ctx);
        registerInterface(IConFeedContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9181E08E");
    }
    private ConFeedContractController getController() throws BOSException
    {
        return (ConFeedContractController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ConFeedContractCollection getConFeedContractCollection() throws BOSException
    {
        try {
            return getController().getConFeedContractCollection(getContext());
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
    public ConFeedContractCollection getConFeedContractCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConFeedContractCollection(getContext(), view);
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
    public ConFeedContractCollection getConFeedContractCollection(String oql) throws BOSException
    {
        try {
            return getController().getConFeedContractCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ConFeedContractInfo getConFeedContractInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedContractInfo(getContext(), pk);
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
    public ConFeedContractInfo getConFeedContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedContractInfo(getContext(), pk, selector);
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
    public ConFeedContractInfo getConFeedContractInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedContractInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(ConFeedContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(ConFeedContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������������-User defined method
     *@param model model
     */
    public void updateFeed(ConFeedContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().updateFeed(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}