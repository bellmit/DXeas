package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.sewagedetection.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckRecord extends WlhlBillBase implements ICheckRecord
{
    public CheckRecord()
    {
        super();
        registerInterface(ICheckRecord.class, this);
    }
    public CheckRecord(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckRecord.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9AC07B1C");
    }
    private CheckRecordController getController() throws BOSException
    {
        return (CheckRecordController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckRecordCollection getCheckRecordCollection() throws BOSException
    {
        try {
            return getController().getCheckRecordCollection(getContext());
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
    public CheckRecordCollection getCheckRecordCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckRecordCollection(getContext(), view);
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
    public CheckRecordCollection getCheckRecordCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckRecordCollection(getContext(), oql);
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
    public CheckRecordInfo getCheckRecordInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRecordInfo(getContext(), pk);
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
    public CheckRecordInfo getCheckRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRecordInfo(getContext(), pk, selector);
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
    public CheckRecordInfo getCheckRecordInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckRecordInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取检测记录-User defined method
     *@param model model
     */
    public void getCheckRecord(CheckRecordInfo model) throws BOSException
    {
        try {
            getController().getCheckRecord(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端查看-User defined method
     *@param model model
     */
    public void modileSee(CheckRecordInfo model) throws BOSException
    {
        try {
            getController().modileSee(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}