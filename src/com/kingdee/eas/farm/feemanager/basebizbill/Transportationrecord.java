package com.kingdee.eas.farm.feemanager.basebizbill;

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
import com.kingdee.eas.farm.feemanager.basebizbill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Transportationrecord extends CoreBillBase implements ITransportationrecord
{
    public Transportationrecord()
    {
        super();
        registerInterface(ITransportationrecord.class, this);
    }
    public Transportationrecord(Context ctx)
    {
        super(ctx);
        registerInterface(ITransportationrecord.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("96CFDA63");
    }
    private TransportationrecordController getController() throws BOSException
    {
        return (TransportationrecordController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public TransportationrecordCollection getTransportationrecordCollection() throws BOSException
    {
        try {
            return getController().getTransportationrecordCollection(getContext());
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
    public TransportationrecordCollection getTransportationrecordCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTransportationrecordCollection(getContext(), view);
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
    public TransportationrecordCollection getTransportationrecordCollection(String oql) throws BOSException
    {
        try {
            return getController().getTransportationrecordCollection(getContext(), oql);
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
    public TransportationrecordInfo getTransportationrecordInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordInfo(getContext(), pk);
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
    public TransportationrecordInfo getTransportationrecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordInfo(getContext(), pk, selector);
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
    public TransportationrecordInfo getTransportationrecordInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(TransportationrecordInfo model) throws BOSException, EASBizException
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
    public void auditback(TransportationrecordInfo model) throws BOSException, EASBizException
    {
        try {
            getController().auditback(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������-User defined method
     *@param model model
     */
    public void sendend(TransportationrecordInfo model) throws BOSException, EASBizException
    {
        try {
            getController().sendend(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�˷Ѽ���-User defined method
     *@param model model
     */
    public void calfright(TransportationrecordInfo model) throws BOSException, EASBizException
    {
        try {
            getController().calfright(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���������Ϣ-User defined method
     *@param model model
     */
    public void updateMileage(TransportationrecordInfo model) throws BOSException
    {
        try {
            getController().updateMileage(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ָ������������-User defined method
     *@param model model
     */
    public void appointPerson(TransportationrecordInfo model) throws BOSException
    {
        try {
            getController().appointPerson(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���¼�¼�鿴-User defined method
     *@param model model
     */
    public void viewUpdateMileage(TransportationrecordInfo model) throws BOSException
    {
        try {
            getController().viewUpdateMileage(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}