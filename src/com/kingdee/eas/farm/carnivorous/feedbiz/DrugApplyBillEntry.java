package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DrugApplyBillEntry extends CoreBillEntryBase implements IDrugApplyBillEntry
{
    public DrugApplyBillEntry()
    {
        super();
        registerInterface(IDrugApplyBillEntry.class, this);
    }
    public DrugApplyBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDrugApplyBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D53D601");
    }
    private DrugApplyBillEntryController getController() throws BOSException
    {
        return (DrugApplyBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillEntryInfo(getContext(), pk);
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
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillEntryInfo(getContext(), pk, selector);
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
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDrugApplyBillEntryCollection(getContext());
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
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDrugApplyBillEntryCollection(getContext(), view);
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
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDrugApplyBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}