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

public class CarviousFeedComMeat extends DataBase implements ICarviousFeedComMeat
{
    public CarviousFeedComMeat()
    {
        super();
        registerInterface(ICarviousFeedComMeat.class, this);
    }
    public CarviousFeedComMeat(Context ctx)
    {
        super(ctx);
        registerInterface(ICarviousFeedComMeat.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0962A446");
    }
    private CarviousFeedComMeatController getController() throws BOSException
    {
        return (CarviousFeedComMeatController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedComMeatInfo(getContext(), pk);
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
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedComMeatInfo(getContext(), pk, selector);
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
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedComMeatInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection() throws BOSException
    {
        try {
            return getController().getCarviousFeedComMeatCollection(getContext());
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
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarviousFeedComMeatCollection(getContext(), view);
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
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarviousFeedComMeatCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��׼-User defined method
     *@param model model
     */
    public void audit(CarviousFeedComMeatInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����׼-User defined method
     *@param model model
     */
    public void unAudit(CarviousFeedComMeatInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}