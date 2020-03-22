package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenRecBill extends CoreBillBase implements IChickenRecBill
{
    public ChickenRecBill()
    {
        super();
        registerInterface(IChickenRecBill.class, this);
    }
    public ChickenRecBill(Context ctx)
    {
        super(ctx);
        registerInterface(IChickenRecBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B283071F");
    }
    private ChickenRecBillController getController() throws BOSException
    {
        return (ChickenRecBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChickenRecBillCollection getChickenRecBillCollection() throws BOSException
    {
        try {
            return getController().getChickenRecBillCollection(getContext());
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
    public ChickenRecBillCollection getChickenRecBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChickenRecBillCollection(getContext(), view);
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
    public ChickenRecBillCollection getChickenRecBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getChickenRecBillCollection(getContext(), oql);
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
    public ChickenRecBillInfo getChickenRecBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenRecBillInfo(getContext(), pk);
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
    public ChickenRecBillInfo getChickenRecBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenRecBillInfo(getContext(), pk, selector);
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
    public ChickenRecBillInfo getChickenRecBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenRecBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ChickenRecBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(ChickenRecBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *派车排序-User defined method
     *@param model model
     *@param map 参数
     */
    public void manageCarSeq(ChickenRecBillInfo model, Map map) throws BOSException, EASBizException
    {
        try {
            getController().manageCarSeq(getContext(), model, map);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}