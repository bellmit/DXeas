package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
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

public class CandlingBillInputModel extends DataBase implements ICandlingBillInputModel
{
    public CandlingBillInputModel()
    {
        super();
        registerInterface(ICandlingBillInputModel.class, this);
    }
    public CandlingBillInputModel(Context ctx)
    {
        super(ctx);
        registerInterface(ICandlingBillInputModel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("939A679E");
    }
    private CandlingBillInputModelController getController() throws BOSException
    {
        return (CandlingBillInputModelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCandlingBillInputModelInfo(getContext(), pk);
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
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCandlingBillInputModelInfo(getContext(), pk, selector);
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
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCandlingBillInputModelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection() throws BOSException
    {
        try {
            return getController().getCandlingBillInputModelCollection(getContext());
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
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCandlingBillInputModelCollection(getContext(), view);
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
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection(String oql) throws BOSException
    {
        try {
            return getController().getCandlingBillInputModelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}