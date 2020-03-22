package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SowPolulationEntry extends CoreBillEntryBase implements ISowPolulationEntry
{
    public SowPolulationEntry()
    {
        super();
        registerInterface(ISowPolulationEntry.class, this);
    }
    public SowPolulationEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISowPolulationEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F01E13E7");
    }
    private SowPolulationEntryController getController() throws BOSException
    {
        return (SowPolulationEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SowPolulationEntryInfo getSowPolulationEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationEntryInfo(getContext(), pk);
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
    public SowPolulationEntryInfo getSowPolulationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationEntryInfo(getContext(), pk, selector);
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
    public SowPolulationEntryInfo getSowPolulationEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SowPolulationEntryCollection getSowPolulationEntryCollection() throws BOSException
    {
        try {
            return getController().getSowPolulationEntryCollection(getContext());
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
    public SowPolulationEntryCollection getSowPolulationEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSowPolulationEntryCollection(getContext(), view);
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
    public SowPolulationEntryCollection getSowPolulationEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSowPolulationEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}