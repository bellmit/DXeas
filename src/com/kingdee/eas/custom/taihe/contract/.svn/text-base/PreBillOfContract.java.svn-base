package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.contract.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PreBillOfContract extends WlhlBillBase implements IPreBillOfContract
{
    public PreBillOfContract()
    {
        super();
        registerInterface(IPreBillOfContract.class, this);
    }
    public PreBillOfContract(Context ctx)
    {
        super(ctx);
        registerInterface(IPreBillOfContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D4B2F957");
    }
    private PreBillOfContractController getController() throws BOSException
    {
        return (PreBillOfContractController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PreBillOfContractCollection getPreBillOfContractCollection() throws BOSException
    {
        try {
            return getController().getPreBillOfContractCollection(getContext());
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
    public PreBillOfContractCollection getPreBillOfContractCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPreBillOfContractCollection(getContext(), view);
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
    public PreBillOfContractCollection getPreBillOfContractCollection(String oql) throws BOSException
    {
        try {
            return getController().getPreBillOfContractCollection(getContext(), oql);
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
    public PreBillOfContractInfo getPreBillOfContractInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPreBillOfContractInfo(getContext(), pk);
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
    public PreBillOfContractInfo getPreBillOfContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPreBillOfContractInfo(getContext(), pk, selector);
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
    public PreBillOfContractInfo getPreBillOfContractInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPreBillOfContractInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}