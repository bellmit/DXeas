package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SowPolulation extends CoreBillBase implements ISowPolulation
{
    public SowPolulation()
    {
        super();
        registerInterface(ISowPolulation.class, this);
    }
    public SowPolulation(Context ctx)
    {
        super(ctx);
        registerInterface(ISowPolulation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EF9E5B4B");
    }
    private SowPolulationController getController() throws BOSException
    {
        return (SowPolulationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SowPolulationCollection getSowPolulationCollection() throws BOSException
    {
        try {
            return getController().getSowPolulationCollection(getContext());
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
    public SowPolulationCollection getSowPolulationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSowPolulationCollection(getContext(), view);
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
    public SowPolulationCollection getSowPolulationCollection(String oql) throws BOSException
    {
        try {
            return getController().getSowPolulationCollection(getContext(), oql);
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
    public SowPolulationInfo getSowPolulationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationInfo(getContext(), pk);
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
    public SowPolulationInfo getSowPolulationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationInfo(getContext(), pk, selector);
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
    public SowPolulationInfo getSowPolulationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSowPolulationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}