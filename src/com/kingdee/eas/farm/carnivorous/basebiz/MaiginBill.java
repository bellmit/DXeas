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

public class MaiginBill extends CoreBillBase implements IMaiginBill
{
    public MaiginBill()
    {
        super();
        registerInterface(IMaiginBill.class, this);
    }
    public MaiginBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMaiginBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AB4CBAD5");
    }
    private MaiginBillController getController() throws BOSException
    {
        return (MaiginBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaiginBillCollection getMaiginBillCollection() throws BOSException
    {
        try {
            return getController().getMaiginBillCollection(getContext());
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
    public MaiginBillCollection getMaiginBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaiginBillCollection(getContext(), view);
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
    public MaiginBillCollection getMaiginBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaiginBillCollection(getContext(), oql);
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
    public MaiginBillInfo getMaiginBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginBillInfo(getContext(), pk);
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
    public MaiginBillInfo getMaiginBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginBillInfo(getContext(), pk, selector);
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
    public MaiginBillInfo getMaiginBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaiginBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MaiginBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(MaiginBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查看担保书-User defined method
     *@param model model
     */
    public void viewGuaranteeBill(MaiginBillInfo model) throws BOSException
    {
        try {
            getController().viewGuaranteeBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}