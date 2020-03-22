package com.kingdee.eas.farm.pig;

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
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigHouseTree extends TreeBase implements IPigHouseTree
{
    public PigHouseTree()
    {
        super();
        registerInterface(IPigHouseTree.class, this);
    }
    public PigHouseTree(Context ctx)
    {
        super(ctx);
        registerInterface(IPigHouseTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BA8C4730");
    }
    private PigHouseTreeController getController() throws BOSException
    {
        return (PigHouseTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public PigHouseTreeInfo getPigHouseTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigHouseTreeInfo(getContext(), pk);
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
    public PigHouseTreeInfo getPigHouseTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigHouseTreeInfo(getContext(), pk, selector);
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
    public PigHouseTreeInfo getPigHouseTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigHouseTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public PigHouseTreeCollection getPigHouseTreeCollection() throws BOSException
    {
        try {
            return getController().getPigHouseTreeCollection(getContext());
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
    public PigHouseTreeCollection getPigHouseTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigHouseTreeCollection(getContext(), view);
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
    public PigHouseTreeCollection getPigHouseTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigHouseTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}