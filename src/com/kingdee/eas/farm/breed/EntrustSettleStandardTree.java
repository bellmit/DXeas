package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EntrustSettleStandardTree extends TreeBase implements IEntrustSettleStandardTree
{
    public EntrustSettleStandardTree()
    {
        super();
        registerInterface(IEntrustSettleStandardTree.class, this);
    }
    public EntrustSettleStandardTree(Context ctx)
    {
        super(ctx);
        registerInterface(IEntrustSettleStandardTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BC38667B");
    }
    private EntrustSettleStandardTreeController getController() throws BOSException
    {
        return (EntrustSettleStandardTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public EntrustSettleStandardTreeInfo getEntrustSettleStandardTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardTreeInfo(getContext(), pk);
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
    public EntrustSettleStandardTreeInfo getEntrustSettleStandardTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardTreeInfo(getContext(), pk, selector);
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
    public EntrustSettleStandardTreeInfo getEntrustSettleStandardTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EntrustSettleStandardTreeCollection getEntrustSettleStandardTreeCollection() throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardTreeCollection(getContext());
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
    public EntrustSettleStandardTreeCollection getEntrustSettleStandardTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardTreeCollection(getContext(), view);
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
    public EntrustSettleStandardTreeCollection getEntrustSettleStandardTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}