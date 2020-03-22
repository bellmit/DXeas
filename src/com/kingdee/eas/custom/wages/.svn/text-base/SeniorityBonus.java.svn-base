package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SeniorityBonus extends WlhlBillBase implements ISeniorityBonus
{
    public SeniorityBonus()
    {
        super();
        registerInterface(ISeniorityBonus.class, this);
    }
    public SeniorityBonus(Context ctx)
    {
        super(ctx);
        registerInterface(ISeniorityBonus.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D12E8049");
    }
    private SeniorityBonusController getController() throws BOSException
    {
        return (SeniorityBonusController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SeniorityBonusCollection getSeniorityBonusCollection() throws BOSException
    {
        try {
            return getController().getSeniorityBonusCollection(getContext());
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
    public SeniorityBonusCollection getSeniorityBonusCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSeniorityBonusCollection(getContext(), view);
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
    public SeniorityBonusCollection getSeniorityBonusCollection(String oql) throws BOSException
    {
        try {
            return getController().getSeniorityBonusCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SeniorityBonusInfo getSeniorityBonusInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSeniorityBonusInfo(getContext(), pk);
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
    public SeniorityBonusInfo getSeniorityBonusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSeniorityBonusInfo(getContext(), pk, selector);
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
    public SeniorityBonusInfo getSeniorityBonusInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSeniorityBonusInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}