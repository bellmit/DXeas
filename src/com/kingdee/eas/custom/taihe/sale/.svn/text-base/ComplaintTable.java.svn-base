package com.kingdee.eas.custom.taihe.sale;

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
import com.kingdee.eas.custom.taihe.sale.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ComplaintTable extends CoreBillBase implements IComplaintTable
{
    public ComplaintTable()
    {
        super();
        registerInterface(IComplaintTable.class, this);
    }
    public ComplaintTable(Context ctx)
    {
        super(ctx);
        registerInterface(IComplaintTable.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AF5C2C2A");
    }
    private ComplaintTableController getController() throws BOSException
    {
        return (ComplaintTableController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ComplaintTableCollection getComplaintTableCollection() throws BOSException
    {
        try {
            return getController().getComplaintTableCollection(getContext());
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
    public ComplaintTableCollection getComplaintTableCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getComplaintTableCollection(getContext(), view);
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
    public ComplaintTableCollection getComplaintTableCollection(String oql) throws BOSException
    {
        try {
            return getController().getComplaintTableCollection(getContext(), oql);
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
    public ComplaintTableInfo getComplaintTableInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableInfo(getContext(), pk);
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
    public ComplaintTableInfo getComplaintTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableInfo(getContext(), pk, selector);
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
    public ComplaintTableInfo getComplaintTableInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getComplaintTableInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}