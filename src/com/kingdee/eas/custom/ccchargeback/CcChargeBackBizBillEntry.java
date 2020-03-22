package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.ccchargeback.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CcChargeBackBizBillEntry extends CoreBillEntryBase implements ICcChargeBackBizBillEntry
{
    public CcChargeBackBizBillEntry()
    {
        super();
        registerInterface(ICcChargeBackBizBillEntry.class, this);
    }
    public CcChargeBackBizBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICcChargeBackBizBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F90CE81B");
    }
    private CcChargeBackBizBillEntryController getController() throws BOSException
    {
        return (CcChargeBackBizBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillEntryInfo(getContext(), pk);
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
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillEntryInfo(getContext(), pk, selector);
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
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCcChargeBackBizBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillEntryCollection(getContext());
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
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillEntryCollection(getContext(), view);
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
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCcChargeBackBizBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}