package com.kingdee.eas.publicdata;

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
import com.kingdee.eas.publicdata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CardSetting extends DataBase implements ICardSetting
{
    public CardSetting()
    {
        super();
        registerInterface(ICardSetting.class, this);
    }
    public CardSetting(Context ctx)
    {
        super(ctx);
        registerInterface(ICardSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B8BF3D5D");
    }
    private CardSettingController getController() throws BOSException
    {
        return (CardSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CardSettingInfo getCardSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCardSettingInfo(getContext(), pk);
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
    public CardSettingInfo getCardSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCardSettingInfo(getContext(), pk, selector);
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
    public CardSettingInfo getCardSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCardSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CardSettingCollection getCardSettingCollection() throws BOSException
    {
        try {
            return getController().getCardSettingCollection(getContext());
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
    public CardSettingCollection getCardSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCardSettingCollection(getContext(), view);
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
    public CardSettingCollection getCardSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getCardSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}