package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialApplyBillEntry extends CoreBillEntryBase implements IMaterialApplyBillEntry
{
    public MaterialApplyBillEntry()
    {
        super();
        registerInterface(IMaterialApplyBillEntry.class, this);
    }
    public MaterialApplyBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialApplyBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("034EB3BE");
    }
    private MaterialApplyBillEntryController getController() throws BOSException
    {
        return (MaterialApplyBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialApplyBillEntryInfo getMaterialApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialApplyBillEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public MaterialApplyBillEntryInfo getMaterialApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialApplyBillEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public MaterialApplyBillEntryInfo getMaterialApplyBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialApplyBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialApplyBillEntryCollection getMaterialApplyBillEntryCollection() throws BOSException
    {
        try {
            return getController().getMaterialApplyBillEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public MaterialApplyBillEntryCollection getMaterialApplyBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialApplyBillEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public MaterialApplyBillEntryCollection getMaterialApplyBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialApplyBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}