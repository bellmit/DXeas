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

public class MileModifyRecord extends CoreBillBase implements IMileModifyRecord
{
    public MileModifyRecord()
    {
        super();
        registerInterface(IMileModifyRecord.class, this);
    }
    public MileModifyRecord(Context ctx)
    {
        super(ctx);
        registerInterface(IMileModifyRecord.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1CEF7B06");
    }
    private MileModifyRecordController getController() throws BOSException
    {
        return (MileModifyRecordController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MileModifyRecordCollection getMileModifyRecordCollection() throws BOSException
    {
        try {
            return getController().getMileModifyRecordCollection(getContext());
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
    public MileModifyRecordCollection getMileModifyRecordCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMileModifyRecordCollection(getContext(), view);
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
    public MileModifyRecordCollection getMileModifyRecordCollection(String oql) throws BOSException
    {
        try {
            return getController().getMileModifyRecordCollection(getContext(), oql);
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
    public MileModifyRecordInfo getMileModifyRecordInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMileModifyRecordInfo(getContext(), pk);
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
    public MileModifyRecordInfo getMileModifyRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMileModifyRecordInfo(getContext(), pk, selector);
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
    public MileModifyRecordInfo getMileModifyRecordInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMileModifyRecordInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}