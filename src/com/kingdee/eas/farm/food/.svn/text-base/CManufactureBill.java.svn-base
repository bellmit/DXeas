package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.scm.im.inv.InvBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CManufactureBill extends InvBillBase implements ICManufactureBill
{
    public CManufactureBill()
    {
        super();
        registerInterface(ICManufactureBill.class, this);
    }
    public CManufactureBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICManufactureBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D66B122F");
    }
    private CManufactureBillController getController() throws BOSException
    {
        return (CManufactureBillController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CManufactureBillInfo getCManufactureBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillInfo(getContext(), pk);
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
    public CManufactureBillInfo getCManufactureBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillInfo(getContext(), pk, selector);
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
    public CManufactureBillInfo getCManufactureBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CManufactureBillCollection getCManufactureBillCollection() throws BOSException
    {
        try {
            return getController().getCManufactureBillCollection(getContext());
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
    public CManufactureBillCollection getCManufactureBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCManufactureBillCollection(getContext(), view);
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
    public CManufactureBillCollection getCManufactureBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCManufactureBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据用户得到默认成本对象-User defined method
     *@param materialId materialId
     *@param companyId companyId
     *@param lot lot
     *@return
     */
    public CManufactureBillInfo getDefaultCostObject(String materialId, String companyId, String lot) throws BOSException, EASBizException
    {
        try {
            return getController().getDefaultCostObject(getContext(), materialId, companyId, lot);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否可以删除(制造接口)-User defined method
     *@param fsourcebillid 来源单据id
     *@return
     */
    public int associateManufactureRecBill(String fsourcebillid) throws BOSException, EASBizException
    {
        try {
            return getController().associateManufactureRecBill(getContext(), fsourcebillid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}