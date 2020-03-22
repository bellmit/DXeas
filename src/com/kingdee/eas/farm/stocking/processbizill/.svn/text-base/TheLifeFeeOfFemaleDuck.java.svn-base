package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TheLifeFeeOfFemaleDuck extends CoreBillBase implements ITheLifeFeeOfFemaleDuck
{
    public TheLifeFeeOfFemaleDuck()
    {
        super();
        registerInterface(ITheLifeFeeOfFemaleDuck.class, this);
    }
    public TheLifeFeeOfFemaleDuck(Context ctx)
    {
        super(ctx);
        registerInterface(ITheLifeFeeOfFemaleDuck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("56FE1CDA");
    }
    private TheLifeFeeOfFemaleDuckController getController() throws BOSException
    {
        return (TheLifeFeeOfFemaleDuckController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection() throws BOSException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckCollection(getContext());
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
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckCollection(getContext(), view);
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
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection(String oql) throws BOSException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckCollection(getContext(), oql);
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
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckInfo(getContext(), pk);
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
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckInfo(getContext(), pk, selector);
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
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTheLifeFeeOfFemaleDuckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(TheLifeFeeOfFemaleDuckInfo model) throws BOSException, EASBizException
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
    public void unAudit(TheLifeFeeOfFemaleDuckInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}