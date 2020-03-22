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

public class GuaranteeApply extends CoreBillBase implements IGuaranteeApply
{
    public GuaranteeApply()
    {
        super();
        registerInterface(IGuaranteeApply.class, this);
    }
    public GuaranteeApply(Context ctx)
    {
        super(ctx);
        registerInterface(IGuaranteeApply.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1ADA8673");
    }
    private GuaranteeApplyController getController() throws BOSException
    {
        return (GuaranteeApplyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public GuaranteeApplyCollection getGuaranteeApplyCollection() throws BOSException
    {
        try {
            return getController().getGuaranteeApplyCollection(getContext());
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
    public GuaranteeApplyCollection getGuaranteeApplyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getGuaranteeApplyCollection(getContext(), view);
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
    public GuaranteeApplyCollection getGuaranteeApplyCollection(String oql) throws BOSException
    {
        try {
            return getController().getGuaranteeApplyCollection(getContext(), oql);
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
    public GuaranteeApplyInfo getGuaranteeApplyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getGuaranteeApplyInfo(getContext(), pk);
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
    public GuaranteeApplyInfo getGuaranteeApplyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getGuaranteeApplyInfo(getContext(), pk, selector);
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
    public GuaranteeApplyInfo getGuaranteeApplyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getGuaranteeApplyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}