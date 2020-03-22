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

public class ComplainBill extends WlhlBillBase implements IComplainBill
{
    public ComplainBill()
    {
        super();
        registerInterface(IComplainBill.class, this);
    }
    public ComplainBill(Context ctx)
    {
        super(ctx);
        registerInterface(IComplainBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2A796EBE");
    }
    private ComplainBillController getController() throws BOSException
    {
        return (ComplainBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ComplainBillCollection getComplainBillCollection() throws BOSException
    {
        try {
            return getController().getComplainBillCollection(getContext());
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
    public ComplainBillCollection getComplainBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getComplainBillCollection(getContext(), view);
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
    public ComplainBillCollection getComplainBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getComplainBillCollection(getContext(), oql);
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
    public ComplainBillInfo getComplainBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainBillInfo(getContext(), pk);
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
    public ComplainBillInfo getComplainBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainBillInfo(getContext(), pk, selector);
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
    public ComplainBillInfo getComplainBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}