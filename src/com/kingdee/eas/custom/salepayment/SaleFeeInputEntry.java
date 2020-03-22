package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleFeeInputEntry extends CoreBillEntryBase implements ISaleFeeInputEntry
{
    public SaleFeeInputEntry()
    {
        super();
        registerInterface(ISaleFeeInputEntry.class, this);
    }
    public SaleFeeInputEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleFeeInputEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7AD49973");
    }
    private SaleFeeInputEntryController getController() throws BOSException
    {
        return (SaleFeeInputEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputEntryInfo(getContext(), pk);
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
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputEntryInfo(getContext(), pk, selector);
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
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection() throws BOSException
    {
        try {
            return getController().getSaleFeeInputEntryCollection(getContext());
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
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleFeeInputEntryCollection(getContext(), view);
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
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleFeeInputEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}