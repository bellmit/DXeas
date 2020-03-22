package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.basebiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginInitBill extends CoreBillBase implements IMarginInitBill
{
    public MarginInitBill()
    {
        super();
        registerInterface(IMarginInitBill.class, this);
    }
    public MarginInitBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginInitBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8E71455C");
    }
    private MarginInitBillController getController() throws BOSException
    {
        return (MarginInitBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public MarginInitBillCollection getMarginInitBillCollection() throws BOSException
    {
        try {
            return getController().getMarginInitBillCollection(getContext());
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
    public MarginInitBillCollection getMarginInitBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginInitBillCollection(getContext(), view);
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
    public MarginInitBillCollection getMarginInitBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginInitBillCollection(getContext(), oql);
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
    public MarginInitBillInfo getMarginInitBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginInitBillInfo(getContext(), pk);
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
    public MarginInitBillInfo getMarginInitBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginInitBillInfo(getContext(), pk, selector);
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
    public MarginInitBillInfo getMarginInitBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginInitBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(MarginInitBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(MarginInitBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}