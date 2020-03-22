package com.kingdee.eas.custom.taihe.sale;

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
import com.kingdee.eas.custom.taihe.sale.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ComplaintTableEntry extends CoreBillEntryBase implements IComplaintTableEntry
{
    public ComplaintTableEntry()
    {
        super();
        registerInterface(IComplaintTableEntry.class, this);
    }
    public ComplaintTableEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IComplaintTableEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EB0AF668");
    }
    private ComplaintTableEntryController getController() throws BOSException
    {
        return (ComplaintTableEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableEntryInfo(getContext(), pk);
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
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableEntryInfo(getContext(), pk, selector);
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
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ComplaintTableEntryCollection getComplaintTableEntryCollection() throws BOSException
    {
        try {
            return getController().getComplaintTableEntryCollection(getContext());
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
    public ComplaintTableEntryCollection getComplaintTableEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getComplaintTableEntryCollection(getContext(), view);
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
    public ComplaintTableEntryCollection getComplaintTableEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getComplaintTableEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}