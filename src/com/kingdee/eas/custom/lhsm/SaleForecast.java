package com.kingdee.eas.custom.lhsm;

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
import com.kingdee.eas.custom.lhsm.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleForecast extends CoreBillBase implements ISaleForecast
{
    public SaleForecast()
    {
        super();
        registerInterface(ISaleForecast.class, this);
    }
    public SaleForecast(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleForecast.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FFAFDB4F");
    }
    private SaleForecastController getController() throws BOSException
    {
        return (SaleForecastController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SaleForecastCollection getSaleForecastCollection() throws BOSException
    {
        try {
            return getController().getSaleForecastCollection(getContext());
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
    public SaleForecastCollection getSaleForecastCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleForecastCollection(getContext(), view);
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
    public SaleForecastCollection getSaleForecastCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleForecastCollection(getContext(), oql);
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
    public SaleForecastInfo getSaleForecastInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastInfo(getContext(), pk);
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
    public SaleForecastInfo getSaleForecastInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastInfo(getContext(), pk, selector);
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
    public SaleForecastInfo getSaleForecastInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(SaleForecastInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(SaleForecastInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���Ȳ�ѯ-User defined method
     *@param model model
     */
    public void progressView(SaleForecastInfo model) throws BOSException
    {
        try {
            getController().progressView(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�鿴����-User defined method
     *@param model model
     */
    public void viewPro(SaleForecastInfo model) throws BOSException
    {
        try {
            getController().viewPro(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}