package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PlatformQuotation extends DataBase implements IPlatformQuotation
{
    public PlatformQuotation()
    {
        super();
        registerInterface(IPlatformQuotation.class, this);
    }
    public PlatformQuotation(Context ctx)
    {
        super(ctx);
        registerInterface(IPlatformQuotation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EECE0F28");
    }
    private PlatformQuotationController getController() throws BOSException
    {
        return (PlatformQuotationController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public PlatformQuotationInfo getPlatformQuotationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatformQuotationInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public PlatformQuotationInfo getPlatformQuotationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatformQuotationInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public PlatformQuotationInfo getPlatformQuotationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatformQuotationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public PlatformQuotationCollection getPlatformQuotationCollection() throws BOSException
    {
        try {
            return getController().getPlatformQuotationCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public PlatformQuotationCollection getPlatformQuotationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPlatformQuotationCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public PlatformQuotationCollection getPlatformQuotationCollection(String oql) throws BOSException
    {
        try {
            return getController().getPlatformQuotationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��׼-User defined method
     *@param model model
     */
    public void audit(PlatformQuotationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����׼-User defined method
     *@param model model
     */
    public void unAudit(PlatformQuotationInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}