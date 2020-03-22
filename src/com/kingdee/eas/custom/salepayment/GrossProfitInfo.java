package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class GrossProfitInfo extends CoreBillBase implements IGrossProfitInfo
{
    public GrossProfitInfo()
    {
        super();
        registerInterface(IGrossProfitInfo.class, this);
    }
    public GrossProfitInfo(Context ctx)
    {
        super(ctx);
        registerInterface(IGrossProfitInfo.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2D158D02");
    }
    private GrossProfitInfoController getController() throws BOSException
    {
        return (GrossProfitInfoController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public GrossProfitInfoCollection getGrossProfitInfoCollection() throws BOSException
    {
        try {
            return getController().getGrossProfitInfoCollection(getContext());
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
    public GrossProfitInfoCollection getGrossProfitInfoCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getGrossProfitInfoCollection(getContext(), view);
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
    public GrossProfitInfoCollection getGrossProfitInfoCollection(String oql) throws BOSException
    {
        try {
            return getController().getGrossProfitInfoCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public GrossProfitInfoInfo getGrossProfitInfoInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoInfo(getContext(), pk);
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
    public GrossProfitInfoInfo getGrossProfitInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoInfo(getContext(), pk, selector);
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
    public GrossProfitInfoInfo getGrossProfitInfoInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}