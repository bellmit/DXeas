package com.kingdee.eas.spray;

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
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SparyRecord extends CoreBillBase implements ISparyRecord
{
    public SparyRecord()
    {
        super();
        registerInterface(ISparyRecord.class, this);
    }
    public SparyRecord(Context ctx)
    {
        super(ctx);
        registerInterface(ISparyRecord.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("33FB8D49");
    }
    private SparyRecordController getController() throws BOSException
    {
        return (SparyRecordController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SparyRecordCollection getSparyRecordCollection() throws BOSException
    {
        try {
            return getController().getSparyRecordCollection(getContext());
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
    public SparyRecordCollection getSparyRecordCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSparyRecordCollection(getContext(), view);
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
    public SparyRecordCollection getSparyRecordCollection(String oql) throws BOSException
    {
        try {
            return getController().getSparyRecordCollection(getContext(), oql);
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
    public SparyRecordInfo getSparyRecordInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordInfo(getContext(), pk);
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
    public SparyRecordInfo getSparyRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordInfo(getContext(), pk, selector);
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
    public SparyRecordInfo getSparyRecordInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}