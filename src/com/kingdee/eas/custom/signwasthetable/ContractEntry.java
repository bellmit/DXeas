package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ContractEntry extends CoreBillEntryBase implements IContractEntry
{
    public ContractEntry()
    {
        super();
        registerInterface(IContractEntry.class, this);
    }
    public ContractEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IContractEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0F1267B6");
    }
    private ContractEntryController getController() throws BOSException
    {
        return (ContractEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ContractEntryInfo getContractEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getContractEntryInfo(getContext(), pk);
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
    public ContractEntryInfo getContractEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getContractEntryInfo(getContext(), pk, selector);
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
    public ContractEntryInfo getContractEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getContractEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ContractEntryCollection getContractEntryCollection() throws BOSException
    {
        try {
            return getController().getContractEntryCollection(getContext());
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
    public ContractEntryCollection getContractEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getContractEntryCollection(getContext(), view);
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
    public ContractEntryCollection getContractEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getContractEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}