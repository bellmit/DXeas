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

public class DailyImmunePlanTree extends TreeBase implements IDailyImmunePlanTree
{
    public DailyImmunePlanTree()
    {
        super();
        registerInterface(IDailyImmunePlanTree.class, this);
    }
    public DailyImmunePlanTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDailyImmunePlanTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3D91BC43");
    }
    private DailyImmunePlanTreeController getController() throws BOSException
    {
        return (DailyImmunePlanTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DailyImmunePlanTreeInfo getDailyImmunePlanTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanTreeInfo(getContext(), pk);
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
    public DailyImmunePlanTreeInfo getDailyImmunePlanTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanTreeInfo(getContext(), pk, selector);
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
    public DailyImmunePlanTreeInfo getDailyImmunePlanTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyImmunePlanTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DailyImmunePlanTreeCollection getDailyImmunePlanTreeCollection() throws BOSException
    {
        try {
            return getController().getDailyImmunePlanTreeCollection(getContext());
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
    public DailyImmunePlanTreeCollection getDailyImmunePlanTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDailyImmunePlanTreeCollection(getContext(), view);
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
    public DailyImmunePlanTreeCollection getDailyImmunePlanTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDailyImmunePlanTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}