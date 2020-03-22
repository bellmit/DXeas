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

public class QCEggScrapBill extends CoreBillBase implements IQCEggScrapBill
{
    public QCEggScrapBill()
    {
        super();
        registerInterface(IQCEggScrapBill.class, this);
    }
    public QCEggScrapBill(Context ctx)
    {
        super(ctx);
        registerInterface(IQCEggScrapBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("03DB4AAA");
    }
    private QCEggScrapBillController getController() throws BOSException
    {
        return (QCEggScrapBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public QCEggScrapBillCollection getQCEggScrapBillCollection() throws BOSException
    {
        try {
            return getController().getQCEggScrapBillCollection(getContext());
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
    public QCEggScrapBillCollection getQCEggScrapBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQCEggScrapBillCollection(getContext(), view);
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
    public QCEggScrapBillCollection getQCEggScrapBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getQCEggScrapBillCollection(getContext(), oql);
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
    public QCEggScrapBillInfo getQCEggScrapBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQCEggScrapBillInfo(getContext(), pk);
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
    public QCEggScrapBillInfo getQCEggScrapBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQCEggScrapBillInfo(getContext(), pk, selector);
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
    public QCEggScrapBillInfo getQCEggScrapBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQCEggScrapBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(QCEggScrapBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(QCEggScrapBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}