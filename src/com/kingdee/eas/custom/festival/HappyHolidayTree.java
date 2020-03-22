package com.kingdee.eas.custom.festival;

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
import com.kingdee.eas.custom.festival.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HappyHolidayTree extends TreeBase implements IHappyHolidayTree
{
    public HappyHolidayTree()
    {
        super();
        registerInterface(IHappyHolidayTree.class, this);
    }
    public HappyHolidayTree(Context ctx)
    {
        super(ctx);
        registerInterface(IHappyHolidayTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("87949721");
    }
    private HappyHolidayTreeController getController() throws BOSException
    {
        return (HappyHolidayTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayTreeInfo(getContext(), pk);
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
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayTreeInfo(getContext(), pk, selector);
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
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHappyHolidayTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection() throws BOSException
    {
        try {
            return getController().getHappyHolidayTreeCollection(getContext());
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
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHappyHolidayTreeCollection(getContext(), view);
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
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getHappyHolidayTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}