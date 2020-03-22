package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EntrustSettleStandard extends DataBase implements IEntrustSettleStandard
{
    public EntrustSettleStandard()
    {
        super();
        registerInterface(IEntrustSettleStandard.class, this);
    }
    public EntrustSettleStandard(Context ctx)
    {
        super(ctx);
        registerInterface(IEntrustSettleStandard.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("38EF653D");
    }
    private EntrustSettleStandardController getController() throws BOSException
    {
        return (EntrustSettleStandardController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardInfo(getContext(), pk);
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
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardInfo(getContext(), pk, selector);
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
    public EntrustSettleStandardInfo getEntrustSettleStandardInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEntrustSettleStandardInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection() throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardCollection(getContext());
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
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardCollection(getContext(), view);
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
    public EntrustSettleStandardCollection getEntrustSettleStandardCollection(String oql) throws BOSException
    {
        try {
            return getController().getEntrustSettleStandardCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}