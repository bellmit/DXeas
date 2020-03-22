package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggReceiveBill extends CoreBillBase implements IEggReceiveBill
{
    public EggReceiveBill()
    {
        super();
        registerInterface(IEggReceiveBill.class, this);
    }
    public EggReceiveBill(Context ctx)
    {
        super(ctx);
        registerInterface(IEggReceiveBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("38D35EAF");
    }
    private EggReceiveBillController getController() throws BOSException
    {
        return (EggReceiveBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EggReceiveBillCollection getEggReceiveBillCollection() throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext());
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
    public EggReceiveBillCollection getEggReceiveBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext(), view);
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
    public EggReceiveBillCollection getEggReceiveBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggReceiveBillCollection(getContext(), oql);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), pk);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), pk, selector);
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
    public EggReceiveBillInfo getEggReceiveBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(EggReceiveBillInfo model) throws BOSException
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
    public void unAudit(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ʾ����-User defined method
     *@param model model
     */
    public void showPriceCol(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().showPriceCol(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�鿴��������-User defined method
     *@param model model
     */
    public void viewAllBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().viewAllBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ɾ�����ε���-User defined method
     *@param model model
     */
    public void deleteDownBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().deleteDownBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɽ��㵥-User defined method
     *@param model model
     */
    public void toSettleBill(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().toSettleBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������ɫ-User defined method
     *@param model model
     */
    public void setColor(EggReceiveBillInfo model) throws BOSException
    {
        try {
            getController().setColor(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}