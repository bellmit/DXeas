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

public class BreedSeedReceiveBill extends CoreBillBase implements IBreedSeedReceiveBill
{
    public BreedSeedReceiveBill()
    {
        super();
        registerInterface(IBreedSeedReceiveBill.class, this);
    }
    public BreedSeedReceiveBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedSeedReceiveBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("681AB2A9");
    }
    private BreedSeedReceiveBillController getController() throws BOSException
    {
        return (BreedSeedReceiveBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection() throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillCollection(getContext());
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
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillCollection(getContext(), view);
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
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillCollection(getContext(), oql);
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
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillInfo(getContext(), pk);
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
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillInfo(getContext(), pk, selector);
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
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *У��ƾ֤-User defined method
     *@param model model
     */
    public void chkVoucherFlag(BreedSeedReceiveBillInfo model) throws BOSException
    {
        try {
            getController().chkVoucherFlag(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȫ��У��ƾ֤-User defined method
     *@param model model
     */
    public void chkVoucherAll(BreedSeedReceiveBillInfo model) throws BOSException
    {
        try {
            getController().chkVoucherAll(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ر�-User defined method
     *@param model model
     */
    public void close(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().close(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ر�-User defined method
     *@param model model
     */
    public void unClose(BreedSeedReceiveBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unClose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���µ���-User defined method
     *@param model model
     */
    public void updatePrice(BreedSeedReceiveBillInfo model) throws BOSException
    {
        try {
            getController().updatePrice(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}