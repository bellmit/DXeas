package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.assistbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FreightMileageBill extends DataBase implements IFreightMileageBill
{
    public FreightMileageBill()
    {
        super();
        registerInterface(IFreightMileageBill.class, this);
    }
    public FreightMileageBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFreightMileageBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9FDB479D");
    }
    private FreightMileageBillController getController() throws BOSException
    {
        return (FreightMileageBillController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FreightMileageBillInfo getFreightMileageBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreightMileageBillInfo(getContext(), pk);
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
    public FreightMileageBillInfo getFreightMileageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreightMileageBillInfo(getContext(), pk, selector);
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
    public FreightMileageBillInfo getFreightMileageBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreightMileageBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreightMileageBillCollection getFreightMileageBillCollection() throws BOSException
    {
        try {
            return getController().getFreightMileageBillCollection(getContext());
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
    public FreightMileageBillCollection getFreightMileageBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreightMileageBillCollection(getContext(), view);
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
    public FreightMileageBillCollection getFreightMileageBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreightMileageBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(FreightMileageBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(FreightMileageBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}