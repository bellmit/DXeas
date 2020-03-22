package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RewardAndPunishItem extends DataBase implements IRewardAndPunishItem
{
    public RewardAndPunishItem()
    {
        super();
        registerInterface(IRewardAndPunishItem.class, this);
    }
    public RewardAndPunishItem(Context ctx)
    {
        super(ctx);
        registerInterface(IRewardAndPunishItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B2AB0AEE");
    }
    private RewardAndPunishItemController getController() throws BOSException
    {
        return (RewardAndPunishItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardAndPunishItemInfo(getContext(), pk);
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
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardAndPunishItemInfo(getContext(), pk, selector);
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
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardAndPunishItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection() throws BOSException
    {
        try {
            return getController().getRewardAndPunishItemCollection(getContext());
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
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRewardAndPunishItemCollection(getContext(), view);
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
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getRewardAndPunishItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(RewardAndPunishItemInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(RewardAndPunishItemInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}