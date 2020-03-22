package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerSettlementOfInterestEditUIEntry extends CoreBillEntryBase implements IFarmerSettlementOfInterestEditUIEntry
{
    public FarmerSettlementOfInterestEditUIEntry()
    {
        super();
        registerInterface(IFarmerSettlementOfInterestEditUIEntry.class, this);
    }
    public FarmerSettlementOfInterestEditUIEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerSettlementOfInterestEditUIEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D99F5A42");
    }
    private FarmerSettlementOfInterestEditUIEntryController getController() throws BOSException
    {
        return (FarmerSettlementOfInterestEditUIEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryInfo(getContext(), pk);
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
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryInfo(getContext(), pk, selector);
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
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection() throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryCollection(getContext());
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
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryCollection(getContext(), view);
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
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}