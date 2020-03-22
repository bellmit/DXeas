package com.kingdee.eas.custom.salaryvoucher;

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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.custom.salaryvoucher.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SalaryVoucherEntry extends CoreBillEntryBase implements ISalaryVoucherEntry
{
    public SalaryVoucherEntry()
    {
        super();
        registerInterface(ISalaryVoucherEntry.class, this);
    }
    public SalaryVoucherEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISalaryVoucherEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("69C849DD");
    }
    private SalaryVoucherEntryController getController() throws BOSException
    {
        return (SalaryVoucherEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SalaryVoucherEntryInfo getSalaryVoucherEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSalaryVoucherEntryInfo(getContext(), pk);
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
    public SalaryVoucherEntryInfo getSalaryVoucherEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSalaryVoucherEntryInfo(getContext(), pk, selector);
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
    public SalaryVoucherEntryInfo getSalaryVoucherEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSalaryVoucherEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SalaryVoucherEntryCollection getSalaryVoucherEntryCollection() throws BOSException
    {
        try {
            return getController().getSalaryVoucherEntryCollection(getContext());
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
    public SalaryVoucherEntryCollection getSalaryVoucherEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSalaryVoucherEntryCollection(getContext(), view);
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
    public SalaryVoucherEntryCollection getSalaryVoucherEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSalaryVoucherEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}