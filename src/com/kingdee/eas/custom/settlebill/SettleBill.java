package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.custom.settlebill.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleBill extends CoreBillBase implements ISettleBill
{
    public SettleBill()
    {
        super();
        registerInterface(ISettleBill.class, this);
    }
    public SettleBill(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B689EA3");
    }
    private SettleBillController getController() throws BOSException
    {
        return (SettleBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SettleBillCollection getSettleBillCollection() throws BOSException
    {
        try {
            return getController().getSettleBillCollection(getContext());
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
    public SettleBillCollection getSettleBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettleBillCollection(getContext(), view);
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
    public SettleBillCollection getSettleBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettleBillCollection(getContext(), oql);
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
    public SettleBillInfo getSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillInfo(getContext(), pk);
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
    public SettleBillInfo getSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillInfo(getContext(), pk, selector);
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
    public SettleBillInfo getSettleBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ�ɱ����-User defined method
     *@param model model
     */
    public void getCostAmt(SettleBillInfo model) throws BOSException
    {
        try {
            getController().getCostAmt(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(SettleBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(SettleBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *У��ƾ֤��־-User defined method
     *@param model model
     */
    public void checkVoucher(SettleBillInfo model) throws BOSException
    {
        try {
            getController().checkVoucher(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ִ�н���-User defined method
     *@param model model
     */
    public void exeSet(SettleBillInfo model) throws BOSException
    {
        try {
            getController().exeSet(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}