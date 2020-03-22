package com.kingdee.eas.farm.stocking.assistfunction;

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
import com.kingdee.eas.farm.stocking.assistfunction.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleBillPrintCount extends CoreBillBase implements ISettleBillPrintCount
{
    public SettleBillPrintCount()
    {
        super();
        registerInterface(ISettleBillPrintCount.class, this);
    }
    public SettleBillPrintCount(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleBillPrintCount.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E79C877F");
    }
    private SettleBillPrintCountController getController() throws BOSException
    {
        return (SettleBillPrintCountController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection() throws BOSException
    {
        try {
            return getController().getSettleBillPrintCountCollection(getContext());
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
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettleBillPrintCountCollection(getContext(), view);
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
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettleBillPrintCountCollection(getContext(), oql);
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
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillPrintCountInfo(getContext(), pk);
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
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillPrintCountInfo(getContext(), pk, selector);
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
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillPrintCountInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}