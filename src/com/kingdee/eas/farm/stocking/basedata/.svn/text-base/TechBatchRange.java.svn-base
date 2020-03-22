package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TechBatchRange extends DataBase implements ITechBatchRange
{
    public TechBatchRange()
    {
        super();
        registerInterface(ITechBatchRange.class, this);
    }
    public TechBatchRange(Context ctx)
    {
        super(ctx);
        registerInterface(ITechBatchRange.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9C469AEA");
    }
    private TechBatchRangeController getController() throws BOSException
    {
        return (TechBatchRangeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TechBatchRangeInfo getTechBatchRangeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTechBatchRangeInfo(getContext(), pk);
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
    public TechBatchRangeInfo getTechBatchRangeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTechBatchRangeInfo(getContext(), pk, selector);
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
    public TechBatchRangeInfo getTechBatchRangeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTechBatchRangeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TechBatchRangeCollection getTechBatchRangeCollection() throws BOSException
    {
        try {
            return getController().getTechBatchRangeCollection(getContext());
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
    public TechBatchRangeCollection getTechBatchRangeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTechBatchRangeCollection(getContext(), view);
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
    public TechBatchRangeCollection getTechBatchRangeCollection(String oql) throws BOSException
    {
        try {
            return getController().getTechBatchRangeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}