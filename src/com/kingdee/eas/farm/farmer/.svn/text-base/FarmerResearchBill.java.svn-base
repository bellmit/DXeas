package com.kingdee.eas.farm.farmer;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.farmer.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerResearchBill extends CoreBillBase implements IFarmerResearchBill
{
    public FarmerResearchBill()
    {
        super();
        registerInterface(IFarmerResearchBill.class, this);
    }
    public FarmerResearchBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerResearchBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E826F98A");
    }
    private FarmerResearchBillController getController() throws BOSException
    {
        return (FarmerResearchBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerResearchBillCollection getFarmerResearchBillCollection() throws BOSException
    {
        try {
            return getController().getFarmerResearchBillCollection(getContext());
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
    public FarmerResearchBillCollection getFarmerResearchBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerResearchBillCollection(getContext(), view);
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
    public FarmerResearchBillCollection getFarmerResearchBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerResearchBillCollection(getContext(), oql);
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
    public FarmerResearchBillInfo getFarmerResearchBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerResearchBillInfo(getContext(), pk);
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
    public FarmerResearchBillInfo getFarmerResearchBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerResearchBillInfo(getContext(), pk, selector);
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
    public FarmerResearchBillInfo getFarmerResearchBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerResearchBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}