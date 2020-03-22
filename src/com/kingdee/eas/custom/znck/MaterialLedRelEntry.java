package com.kingdee.eas.custom.znck;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.znck.app.*;
import java.lang.String;
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

public class MaterialLedRelEntry extends CoreBillEntryBase implements IMaterialLedRelEntry
{
    public MaterialLedRelEntry()
    {
        super();
        registerInterface(IMaterialLedRelEntry.class, this);
    }
    public MaterialLedRelEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialLedRelEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A37BFE16");
    }
    private MaterialLedRelEntryController getController() throws BOSException
    {
        return (MaterialLedRelEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public MaterialLedRelEntryInfo getMaterialLedRelEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelEntryInfo(getContext(), pk);
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
    public MaterialLedRelEntryInfo getMaterialLedRelEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelEntryInfo(getContext(), pk, selector);
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
    public MaterialLedRelEntryInfo getMaterialLedRelEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public MaterialLedRelEntryCollection getMaterialLedRelEntryCollection() throws BOSException
    {
        try {
            return getController().getMaterialLedRelEntryCollection(getContext());
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
    public MaterialLedRelEntryCollection getMaterialLedRelEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialLedRelEntryCollection(getContext(), view);
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
    public MaterialLedRelEntryCollection getMaterialLedRelEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialLedRelEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}