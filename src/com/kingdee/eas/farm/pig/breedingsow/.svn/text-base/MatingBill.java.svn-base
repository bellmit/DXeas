package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MatingBill extends CoreBillBase implements IMatingBill
{
    public MatingBill()
    {
        super();
        registerInterface(IMatingBill.class, this);
    }
    public MatingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMatingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C17BBE8A");
    }
    private MatingBillController getController() throws BOSException
    {
        return (MatingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MatingBillCollection getMatingBillCollection() throws BOSException
    {
        try {
            return getController().getMatingBillCollection(getContext());
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
    public MatingBillCollection getMatingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMatingBillCollection(getContext(), view);
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
    public MatingBillCollection getMatingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMatingBillCollection(getContext(), oql);
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
    public MatingBillInfo getMatingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillInfo(getContext(), pk);
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
    public MatingBillInfo getMatingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillInfo(getContext(), pk, selector);
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
    public MatingBillInfo getMatingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMatingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}