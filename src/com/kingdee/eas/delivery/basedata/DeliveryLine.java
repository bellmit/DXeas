package com.kingdee.eas.delivery.basedata;

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
import com.kingdee.eas.delivery.basedata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DeliveryLine extends DataBase implements IDeliveryLine
{
    public DeliveryLine()
    {
        super();
        registerInterface(IDeliveryLine.class, this);
    }
    public DeliveryLine(Context ctx)
    {
        super(ctx);
        registerInterface(IDeliveryLine.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("23EE40F3");
    }
    private DeliveryLineController getController() throws BOSException
    {
        return (DeliveryLineController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DeliveryLineInfo getDeliveryLineInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryLineInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@param selector selector
     *@return
     */
    public DeliveryLineInfo getDeliveryLineInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryLineInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public DeliveryLineInfo getDeliveryLineInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryLineInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DeliveryLineCollection getDeliveryLineCollection() throws BOSException
    {
        try {
            return getController().getDeliveryLineCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param view view
     *@return
     */
    public DeliveryLineCollection getDeliveryLineCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeliveryLineCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param oql oql
     *@return
     */
    public DeliveryLineCollection getDeliveryLineCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeliveryLineCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}