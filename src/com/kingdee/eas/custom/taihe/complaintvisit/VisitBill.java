package com.kingdee.eas.custom.taihe.complaintvisit;

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
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.complaintvisit.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VisitBill extends WlhlBillBase implements IVisitBill
{
    public VisitBill()
    {
        super();
        registerInterface(IVisitBill.class, this);
    }
    public VisitBill(Context ctx)
    {
        super(ctx);
        registerInterface(IVisitBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("26F7D484");
    }
    private VisitBillController getController() throws BOSException
    {
        return (VisitBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VisitBillCollection getVisitBillCollection() throws BOSException
    {
        try {
            return getController().getVisitBillCollection(getContext());
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
    public VisitBillCollection getVisitBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVisitBillCollection(getContext(), view);
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
    public VisitBillCollection getVisitBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getVisitBillCollection(getContext(), oql);
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
    public VisitBillInfo getVisitBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVisitBillInfo(getContext(), pk);
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
    public VisitBillInfo getVisitBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVisitBillInfo(getContext(), pk, selector);
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
    public VisitBillInfo getVisitBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVisitBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}