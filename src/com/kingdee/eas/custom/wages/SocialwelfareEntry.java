package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SocialwelfareEntry extends CoreBillEntryBase implements ISocialwelfareEntry
{
    public SocialwelfareEntry()
    {
        super();
        registerInterface(ISocialwelfareEntry.class, this);
    }
    public SocialwelfareEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISocialwelfareEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("49FA113B");
    }
    private SocialwelfareEntryController getController() throws BOSException
    {
        return (SocialwelfareEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SocialwelfareEntryInfo getSocialwelfareEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareEntryInfo(getContext(), pk);
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
    public SocialwelfareEntryInfo getSocialwelfareEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareEntryInfo(getContext(), pk, selector);
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
    public SocialwelfareEntryInfo getSocialwelfareEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSocialwelfareEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SocialwelfareEntryCollection getSocialwelfareEntryCollection() throws BOSException
    {
        try {
            return getController().getSocialwelfareEntryCollection(getContext());
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
    public SocialwelfareEntryCollection getSocialwelfareEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSocialwelfareEntryCollection(getContext(), view);
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
    public SocialwelfareEntryCollection getSocialwelfareEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSocialwelfareEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}