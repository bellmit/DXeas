package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKPECostbill extends CoreBillBase implements ICKPECostbill
{
    public CKPECostbill()
    {
        super();
        registerInterface(ICKPECostbill.class, this);
    }
    public CKPECostbill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKPECostbill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E6FEEDCE");
    }
    private CKPECostbillController getController() throws BOSException
    {
        return (CKPECostbillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKPECostbillCollection getCKPECostbillCollection() throws BOSException
    {
        try {
            return getController().getCKPECostbillCollection(getContext());
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
    public CKPECostbillCollection getCKPECostbillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKPECostbillCollection(getContext(), view);
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
    public CKPECostbillCollection getCKPECostbillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKPECostbillCollection(getContext(), oql);
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
    public CKPECostbillInfo getCKPECostbillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKPECostbillInfo(getContext(), pk);
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
    public CKPECostbillInfo getCKPECostbillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKPECostbillInfo(getContext(), pk, selector);
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
    public CKPECostbillInfo getCKPECostbillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKPECostbillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}