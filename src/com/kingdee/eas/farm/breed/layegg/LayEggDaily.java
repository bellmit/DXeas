package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LayEggDaily extends CoreBillBase implements ILayEggDaily
{
    public LayEggDaily()
    {
        super();
        registerInterface(ILayEggDaily.class, this);
    }
    public LayEggDaily(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2472242B");
    }
    private LayEggDailyController getController() throws BOSException
    {
        return (LayEggDailyController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LayEggDailyCollection getLayEggDailyCollection() throws BOSException
    {
        try {
            return getController().getLayEggDailyCollection(getContext());
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
    public LayEggDailyCollection getLayEggDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLayEggDailyCollection(getContext(), view);
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
    public LayEggDailyCollection getLayEggDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getLayEggDailyCollection(getContext(), oql);
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
    public LayEggDailyInfo getLayEggDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyInfo(getContext(), pk);
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
    public LayEggDailyInfo getLayEggDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyInfo(getContext(), pk, selector);
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
    public LayEggDailyInfo getLayEggDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(LayEggDailyInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(LayEggDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������ε���-User defined method
     *@param model model
     *@return
     */
    public List genNextBill(LayEggDailyInfo model) throws BOSException
    {
        try {
            return getController().genNextBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���·�̯�����͹���-User defined method
     *@param model model
     */
    public void reShareInfos(LayEggDailyInfo model) throws BOSException
    {
        try {
            getController().reShareInfos(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ˢ�¿��-User defined method
     *@param model model
     */
    public void refreshInventory(LayEggDailyInfo model) throws BOSException
    {
        try {
            getController().refreshInventory(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɷ����ձ�-User defined method
     *@param model model
     */
    public void toStockDaily(LayEggDailyInfo model) throws BOSException
    {
        try {
            getController().toStockDaily(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}