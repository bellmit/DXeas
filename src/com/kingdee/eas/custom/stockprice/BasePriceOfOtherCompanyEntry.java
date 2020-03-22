package com.kingdee.eas.custom.stockprice;

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
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasePriceOfOtherCompanyEntry extends CoreBillEntryBase implements IBasePriceOfOtherCompanyEntry
{
    public BasePriceOfOtherCompanyEntry()
    {
        super();
        registerInterface(IBasePriceOfOtherCompanyEntry.class, this);
    }
    public BasePriceOfOtherCompanyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBasePriceOfOtherCompanyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3A630866");
    }
    private BasePriceOfOtherCompanyEntryController getController() throws BOSException
    {
        return (BasePriceOfOtherCompanyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BasePriceOfOtherCompanyEntryInfo getBasePriceOfOtherCompanyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryInfo(getContext(), pk);
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
    public BasePriceOfOtherCompanyEntryInfo getBasePriceOfOtherCompanyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryInfo(getContext(), pk, selector);
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
    public BasePriceOfOtherCompanyEntryInfo getBasePriceOfOtherCompanyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasePriceOfOtherCompanyEntryCollection getBasePriceOfOtherCompanyEntryCollection() throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryCollection(getContext());
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
    public BasePriceOfOtherCompanyEntryCollection getBasePriceOfOtherCompanyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryCollection(getContext(), view);
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
    public BasePriceOfOtherCompanyEntryCollection getBasePriceOfOtherCompanyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasePriceOfOtherCompanyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}