package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ArrangementBreedBill extends CoreBillBase implements IArrangementBreedBill
{
    public ArrangementBreedBill()
    {
        super();
        registerInterface(IArrangementBreedBill.class, this);
    }
    public ArrangementBreedBill(Context ctx)
    {
        super(ctx);
        registerInterface(IArrangementBreedBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("229F1696");
    }
    private ArrangementBreedBillController getController() throws BOSException
    {
        return (ArrangementBreedBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ArrangementBreedBillCollection getArrangementBreedBillCollection() throws BOSException
    {
        try {
            return getController().getArrangementBreedBillCollection(getContext());
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
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getArrangementBreedBillCollection(getContext(), view);
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
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getArrangementBreedBillCollection(getContext(), oql);
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
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getArrangementBreedBillInfo(getContext(), pk);
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
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getArrangementBreedBillInfo(getContext(), pk, selector);
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
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getArrangementBreedBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ArrangementBreedBillInfo model) throws BOSException
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
    public void unAudit(ArrangementBreedBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}