package com.kingdee.eas.farm.pig.ccpig;

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
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCPigDaily extends CoreBillBase implements ICCPigDaily
{
    public CCPigDaily()
    {
        super();
        registerInterface(ICCPigDaily.class, this);
    }
    public CCPigDaily(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BFD97A4B");
    }
    private CCPigDailyController getController() throws BOSException
    {
        return (CCPigDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCPigDailyCollection getCCPigDailyCollection() throws BOSException
    {
        try {
            return getController().getCCPigDailyCollection(getContext());
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
    public CCPigDailyCollection getCCPigDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCPigDailyCollection(getContext(), view);
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
    public CCPigDailyCollection getCCPigDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCPigDailyCollection(getContext(), oql);
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
    public CCPigDailyInfo getCCPigDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigDailyInfo(getContext(), pk);
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
    public CCPigDailyInfo getCCPigDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigDailyInfo(getContext(), pk, selector);
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
    public CCPigDailyInfo getCCPigDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CCPigDailyInfo model) throws BOSException
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
    public void unAudit(CCPigDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}