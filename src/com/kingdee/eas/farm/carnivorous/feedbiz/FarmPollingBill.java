package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmPollingBill extends CoreBillBase implements IFarmPollingBill
{
    public FarmPollingBill()
    {
        super();
        registerInterface(IFarmPollingBill.class, this);
    }
    public FarmPollingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmPollingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("862C8570");
    }
    private FarmPollingBillController getController() throws BOSException
    {
        return (FarmPollingBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FarmPollingBillCollection getFarmPollingBillCollection() throws BOSException
    {
        try {
            return getController().getFarmPollingBillCollection(getContext());
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
    public FarmPollingBillCollection getFarmPollingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmPollingBillCollection(getContext(), view);
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
    public FarmPollingBillCollection getFarmPollingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmPollingBillCollection(getContext(), oql);
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
    public FarmPollingBillInfo getFarmPollingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPollingBillInfo(getContext(), pk);
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
    public FarmPollingBillInfo getFarmPollingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPollingBillInfo(getContext(), pk, selector);
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
    public FarmPollingBillInfo getFarmPollingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPollingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ͼƬչʾ-User defined method
     *@param model model
     */
    public void displayPic(FarmPollingBillInfo model) throws BOSException
    {
        try {
            getController().displayPic(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(FarmPollingBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmPollingBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}