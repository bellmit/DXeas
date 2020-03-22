package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialStandardCost extends DataBase implements IMaterialStandardCost
{
    public MaterialStandardCost()
    {
        super();
        registerInterface(IMaterialStandardCost.class, this);
    }
    public MaterialStandardCost(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialStandardCost.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B6F01FE5");
    }
    private MaterialStandardCostController getController() throws BOSException
    {
        return (MaterialStandardCostController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialStandardCostInfo getMaterialStandardCostInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostInfo(getContext(), pk);
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
    public MaterialStandardCostInfo getMaterialStandardCostInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostInfo(getContext(), pk, selector);
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
    public MaterialStandardCostInfo getMaterialStandardCostInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialStandardCostCollection getMaterialStandardCostCollection() throws BOSException
    {
        try {
            return getController().getMaterialStandardCostCollection(getContext());
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
    public MaterialStandardCostCollection getMaterialStandardCostCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialStandardCostCollection(getContext(), view);
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
    public MaterialStandardCostCollection getMaterialStandardCostCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialStandardCostCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MaterialStandardCostInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(MaterialStandardCostInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}