package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ParentBreedBatch extends CoreBillBase implements IParentBreedBatch
{
    public ParentBreedBatch()
    {
        super();
        registerInterface(IParentBreedBatch.class, this);
    }
    public ParentBreedBatch(Context ctx)
    {
        super(ctx);
        registerInterface(IParentBreedBatch.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0238F3CA");
    }
    private ParentBreedBatchController getController() throws BOSException
    {
        return (ParentBreedBatchController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ParentBreedBatchCollection getParentBreedBatchCollection() throws BOSException
    {
        try {
            return getController().getParentBreedBatchCollection(getContext());
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
    public ParentBreedBatchCollection getParentBreedBatchCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getParentBreedBatchCollection(getContext(), view);
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
    public ParentBreedBatchCollection getParentBreedBatchCollection(String oql) throws BOSException
    {
        try {
            return getController().getParentBreedBatchCollection(getContext(), oql);
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
    public ParentBreedBatchInfo getParentBreedBatchInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getParentBreedBatchInfo(getContext(), pk);
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
    public ParentBreedBatchInfo getParentBreedBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getParentBreedBatchInfo(getContext(), pk, selector);
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
    public ParentBreedBatchInfo getParentBreedBatchInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getParentBreedBatchInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(ParentBreedBatchInfo model) throws BOSException
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
    public void unAudit(ParentBreedBatchInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���·�¼����״̬-User defined method
     *@param model model
     */
    public void updateBatchMarket(ParentBreedBatchInfo model) throws BOSException
    {
        try {
            getController().updateBatchMarket(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}