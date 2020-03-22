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

public class MaiginReturnBill extends CoreBillBase implements IMaiginReturnBill
{
    public MaiginReturnBill()
    {
        super();
        registerInterface(IMaiginReturnBill.class, this);
    }
    public MaiginReturnBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMaiginReturnBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("244581A5");
    }
    private MaiginReturnBillController getController() throws BOSException
    {
        return (MaiginReturnBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaiginReturnBillCollection getMaiginReturnBillCollection() throws BOSException
    {
        try {
            return getController().getMaiginReturnBillCollection(getContext());
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
    public MaiginReturnBillCollection getMaiginReturnBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaiginReturnBillCollection(getContext(), view);
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
    public MaiginReturnBillCollection getMaiginReturnBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaiginReturnBillCollection(getContext(), oql);
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
    public MaiginReturnBillInfo getMaiginReturnBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginReturnBillInfo(getContext(), pk);
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
    public MaiginReturnBillInfo getMaiginReturnBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginReturnBillInfo(getContext(), pk, selector);
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
    public MaiginReturnBillInfo getMaiginReturnBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginReturnBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MaiginReturnBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(MaiginReturnBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}