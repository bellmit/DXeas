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

public class SowAbortionEntry extends CoreBillEntryBase implements ISowAbortionEntry
{
    public SowAbortionEntry()
    {
        super();
        registerInterface(ISowAbortionEntry.class, this);
    }
    public SowAbortionEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISowAbortionEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1028B2C0");
    }
    private SowAbortionEntryController getController() throws BOSException
    {
        return (SowAbortionEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SowAbortionEntryInfo getSowAbortionEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSowAbortionEntryInfo(getContext(), pk);
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
    public SowAbortionEntryInfo getSowAbortionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSowAbortionEntryInfo(getContext(), pk, selector);
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
    public SowAbortionEntryInfo getSowAbortionEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSowAbortionEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SowAbortionEntryCollection getSowAbortionEntryCollection() throws BOSException
    {
        try {
            return getController().getSowAbortionEntryCollection(getContext());
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
    public SowAbortionEntryCollection getSowAbortionEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSowAbortionEntryCollection(getContext(), view);
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
    public SowAbortionEntryCollection getSowAbortionEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSowAbortionEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}