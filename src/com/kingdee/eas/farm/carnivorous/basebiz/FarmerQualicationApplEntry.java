package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.farm.carnivorous.basebiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerQualicationApplEntry extends CoreBillEntryBase implements IFarmerQualicationApplEntry
{
    public FarmerQualicationApplEntry()
    {
        super();
        registerInterface(IFarmerQualicationApplEntry.class, this);
    }
    public FarmerQualicationApplEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerQualicationApplEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1949BA15");
    }
    private FarmerQualicationApplEntryController getController() throws BOSException
    {
        return (FarmerQualicationApplEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplEntryInfo(getContext(), pk);
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
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplEntryInfo(getContext(), pk, selector);
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
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerQualicationApplEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection() throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplEntryCollection(getContext());
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
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplEntryCollection(getContext(), view);
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
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerQualicationApplEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}