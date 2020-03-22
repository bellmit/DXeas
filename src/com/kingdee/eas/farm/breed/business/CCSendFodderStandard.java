package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCSendFodderStandard extends DataBase implements ICCSendFodderStandard
{
    public CCSendFodderStandard()
    {
        super();
        registerInterface(ICCSendFodderStandard.class, this);
    }
    public CCSendFodderStandard(Context ctx)
    {
        super(ctx);
        registerInterface(ICCSendFodderStandard.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D0118CA9");
    }
    private CCSendFodderStandardController getController() throws BOSException
    {
        return (CCSendFodderStandardController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardInfo(getContext(), pk);
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
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardInfo(getContext(), pk, selector);
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
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection() throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardCollection(getContext());
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
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardCollection(getContext(), view);
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
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}