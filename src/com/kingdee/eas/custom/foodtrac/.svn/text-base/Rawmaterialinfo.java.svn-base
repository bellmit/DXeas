package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Rawmaterialinfo extends CoreBillBase implements IRawmaterialinfo
{
    public Rawmaterialinfo()
    {
        super();
        registerInterface(IRawmaterialinfo.class, this);
    }
    public Rawmaterialinfo(Context ctx)
    {
        super(ctx);
        registerInterface(IRawmaterialinfo.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C95BA718");
    }
    private RawmaterialinfoController getController() throws BOSException
    {
        return (RawmaterialinfoController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RawmaterialinfoCollection getRawmaterialinfoCollection() throws BOSException
    {
        try {
            return getController().getRawmaterialinfoCollection(getContext());
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
    public RawmaterialinfoCollection getRawmaterialinfoCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRawmaterialinfoCollection(getContext(), view);
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
    public RawmaterialinfoCollection getRawmaterialinfoCollection(String oql) throws BOSException
    {
        try {
            return getController().getRawmaterialinfoCollection(getContext(), oql);
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
    public RawmaterialinfoInfo getRawmaterialinfoInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoInfo(getContext(), pk);
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
    public RawmaterialinfoInfo getRawmaterialinfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoInfo(getContext(), pk, selector);
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
    public RawmaterialinfoInfo getRawmaterialinfoInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}