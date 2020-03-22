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

public class CCarSendBill extends CoreBillBase implements ICCarSendBill
{
    public CCarSendBill()
    {
        super();
        registerInterface(ICCarSendBill.class, this);
    }
    public CCarSendBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICCarSendBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EC5D9C5D");
    }
    private CCarSendBillController getController() throws BOSException
    {
        return (CCarSendBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CCarSendBillCollection getCCarSendBillCollection() throws BOSException
    {
        try {
            return getController().getCCarSendBillCollection(getContext());
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
    public CCarSendBillCollection getCCarSendBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCarSendBillCollection(getContext(), view);
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
    public CCarSendBillCollection getCCarSendBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCarSendBillCollection(getContext(), oql);
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
    public CCarSendBillInfo getCCarSendBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCarSendBillInfo(getContext(), pk);
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
    public CCarSendBillInfo getCCarSendBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCarSendBillInfo(getContext(), pk, selector);
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
    public CCarSendBillInfo getCCarSendBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCarSendBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(CCarSendBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CCarSendBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ָ��-User defined method
     *@param model model
     *@param map ����
     */
    public void manageSendCar(CCarSendBillInfo model, Map map) throws BOSException, EASBizException
    {
        try {
            getController().manageSendCar(getContext(), model, map);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}