package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerSettlementOfInterestEditUI extends CoreBillBase implements IFarmerSettlementOfInterestEditUI
{
    public FarmerSettlementOfInterestEditUI()
    {
        super();
        registerInterface(IFarmerSettlementOfInterestEditUI.class, this);
    }
    public FarmerSettlementOfInterestEditUI(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerSettlementOfInterestEditUI.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("977B4810");
    }
    private FarmerSettlementOfInterestEditUIController getController() throws BOSException
    {
        return (FarmerSettlementOfInterestEditUIController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection() throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUICollection(getContext());
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
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUICollection(getContext(), view);
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
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUICollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIInfo(getContext(), pk);
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
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIInfo(getContext(), pk, selector);
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
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerSettlementOfInterestEditUIInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}