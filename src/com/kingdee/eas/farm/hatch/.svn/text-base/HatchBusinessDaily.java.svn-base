package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class HatchBusinessDaily extends CoreBillBase implements IHatchBusinessDaily
{
    public HatchBusinessDaily()
    {
        super();
        registerInterface(IHatchBusinessDaily.class, this);
    }
    public HatchBusinessDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBusinessDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("049F6067");
    }
    private HatchBusinessDailyController getController() throws BOSException
    {
        return (HatchBusinessDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection() throws BOSException
    {
        try {
            return getController().getHatchBusinessDailyCollection(getContext());
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
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBusinessDailyCollection(getContext(), view);
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
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBusinessDailyCollection(getContext(), oql);
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
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBusinessDailyInfo(getContext(), pk);
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
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBusinessDailyInfo(getContext(), pk, selector);
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
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBusinessDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(HatchBusinessDailyInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(HatchBusinessDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}