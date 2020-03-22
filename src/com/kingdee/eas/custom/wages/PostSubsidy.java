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

public class PostSubsidy extends WlhlBillBase implements IPostSubsidy
{
    public PostSubsidy()
    {
        super();
        registerInterface(IPostSubsidy.class, this);
    }
    public PostSubsidy(Context ctx)
    {
        super(ctx);
        registerInterface(IPostSubsidy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("52F0D5E3");
    }
    private PostSubsidyController getController() throws BOSException
    {
        return (PostSubsidyController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public PostSubsidyCollection getPostSubsidyCollection() throws BOSException
    {
        try {
            return getController().getPostSubsidyCollection(getContext());
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
    public PostSubsidyCollection getPostSubsidyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPostSubsidyCollection(getContext(), view);
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
    public PostSubsidyCollection getPostSubsidyCollection(String oql) throws BOSException
    {
        try {
            return getController().getPostSubsidyCollection(getContext(), oql);
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
    public PostSubsidyInfo getPostSubsidyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPostSubsidyInfo(getContext(), pk);
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
    public PostSubsidyInfo getPostSubsidyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPostSubsidyInfo(getContext(), pk, selector);
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
    public PostSubsidyInfo getPostSubsidyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPostSubsidyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}