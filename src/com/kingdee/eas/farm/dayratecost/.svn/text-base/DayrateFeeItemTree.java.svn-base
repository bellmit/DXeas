package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DayrateFeeItemTree extends TreeBase implements IDayrateFeeItemTree
{
    public DayrateFeeItemTree()
    {
        super();
        registerInterface(IDayrateFeeItemTree.class, this);
    }
    public DayrateFeeItemTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDayrateFeeItemTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CAD34D00");
    }
    private DayrateFeeItemTreeController getController() throws BOSException
    {
        return (DayrateFeeItemTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DayrateFeeItemTreeInfo getDayrateFeeItemTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemTreeInfo(getContext(), pk);
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
    public DayrateFeeItemTreeInfo getDayrateFeeItemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemTreeInfo(getContext(), pk, selector);
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
    public DayrateFeeItemTreeInfo getDayrateFeeItemTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayrateFeeItemTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DayrateFeeItemTreeCollection getDayrateFeeItemTreeCollection() throws BOSException
    {
        try {
            return getController().getDayrateFeeItemTreeCollection(getContext());
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
    public DayrateFeeItemTreeCollection getDayrateFeeItemTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayrateFeeItemTreeCollection(getContext(), view);
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
    public DayrateFeeItemTreeCollection getDayrateFeeItemTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayrateFeeItemTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}