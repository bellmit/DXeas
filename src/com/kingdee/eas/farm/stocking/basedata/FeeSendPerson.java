package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
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

public class FeeSendPerson extends DataBase implements IFeeSendPerson
{
    public FeeSendPerson()
    {
        super();
        registerInterface(IFeeSendPerson.class, this);
    }
    public FeeSendPerson(Context ctx)
    {
        super(ctx);
        registerInterface(IFeeSendPerson.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B2617972");
    }
    private FeeSendPersonController getController() throws BOSException
    {
        return (FeeSendPersonController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FeeSendPersonInfo getFeeSendPersonInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeeSendPersonInfo(getContext(), pk);
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
    public FeeSendPersonInfo getFeeSendPersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeeSendPersonInfo(getContext(), pk, selector);
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
    public FeeSendPersonInfo getFeeSendPersonInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeeSendPersonInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FeeSendPersonCollection getFeeSendPersonCollection() throws BOSException
    {
        try {
            return getController().getFeeSendPersonCollection(getContext());
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
    public FeeSendPersonCollection getFeeSendPersonCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeeSendPersonCollection(getContext(), view);
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
    public FeeSendPersonCollection getFeeSendPersonCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeeSendPersonCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}