package com.kingdee.eas.custom.znck;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.znck.app.*;
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

public class MaterialLedRel extends CoreBillBase implements IMaterialLedRel
{
    public MaterialLedRel()
    {
        super();
        registerInterface(IMaterialLedRel.class, this);
    }
    public MaterialLedRel(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialLedRel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4AD48FBC");
    }
    private MaterialLedRelController getController() throws BOSException
    {
        return (MaterialLedRelController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialLedRelCollection getMaterialLedRelCollection() throws BOSException
    {
        try {
            return getController().getMaterialLedRelCollection(getContext());
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
    public MaterialLedRelCollection getMaterialLedRelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialLedRelCollection(getContext(), view);
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
    public MaterialLedRelCollection getMaterialLedRelCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialLedRelCollection(getContext(), oql);
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
    public MaterialLedRelInfo getMaterialLedRelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelInfo(getContext(), pk);
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
    public MaterialLedRelInfo getMaterialLedRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelInfo(getContext(), pk, selector);
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
    public MaterialLedRelInfo getMaterialLedRelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialLedRelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}