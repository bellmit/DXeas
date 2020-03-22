package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class TAttendFarmRecord extends CoreBillBase implements ITAttendFarmRecord
{
    public TAttendFarmRecord()
    {
        super();
        registerInterface(ITAttendFarmRecord.class, this);
    }
    public TAttendFarmRecord(Context ctx)
    {
        super(ctx);
        registerInterface(ITAttendFarmRecord.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("63ECD80B");
    }
    private TAttendFarmRecordController getController() throws BOSException
    {
        return (TAttendFarmRecordController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection() throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordCollection(getContext());
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
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordCollection(getContext(), view);
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
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection(String oql) throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordCollection(getContext(), oql);
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
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordInfo(getContext(), pk);
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
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordInfo(getContext(), pk, selector);
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
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(TAttendFarmRecordInfo model) throws BOSException
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
    public void unaudit(TAttendFarmRecordInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}