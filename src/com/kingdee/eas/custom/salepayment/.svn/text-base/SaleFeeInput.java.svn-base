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

public class SaleFeeInput extends CoreBillBase implements ISaleFeeInput
{
    public SaleFeeInput()
    {
        super();
        registerInterface(ISaleFeeInput.class, this);
    }
    public SaleFeeInput(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleFeeInput.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B5F58E3F");
    }
    private SaleFeeInputController getController() throws BOSException
    {
        return (SaleFeeInputController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SaleFeeInputCollection getSaleFeeInputCollection() throws BOSException
    {
        try {
            return getController().getSaleFeeInputCollection(getContext());
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
    public SaleFeeInputCollection getSaleFeeInputCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleFeeInputCollection(getContext(), view);
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
    public SaleFeeInputCollection getSaleFeeInputCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleFeeInputCollection(getContext(), oql);
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
    public SaleFeeInputInfo getSaleFeeInputInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputInfo(getContext(), pk);
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
    public SaleFeeInputInfo getSaleFeeInputInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputInfo(getContext(), pk, selector);
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
    public SaleFeeInputInfo getSaleFeeInputInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleFeeInputInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}