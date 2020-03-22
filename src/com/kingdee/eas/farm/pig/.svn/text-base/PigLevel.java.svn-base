package com.kingdee.eas.farm.pig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigLevel extends DataBase implements IPigLevel
{
    public PigLevel()
    {
        super();
        registerInterface(IPigLevel.class, this);
    }
    public PigLevel(Context ctx)
    {
        super(ctx);
        registerInterface(IPigLevel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FF85BCD6");
    }
    private PigLevelController getController() throws BOSException
    {
        return (PigLevelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigLevelInfo getPigLevelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigLevelInfo(getContext(), pk);
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
    public PigLevelInfo getPigLevelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigLevelInfo(getContext(), pk, selector);
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
    public PigLevelInfo getPigLevelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigLevelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigLevelCollection getPigLevelCollection() throws BOSException
    {
        try {
            return getController().getPigLevelCollection(getContext());
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
    public PigLevelCollection getPigLevelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigLevelCollection(getContext(), view);
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
    public PigLevelCollection getPigLevelCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigLevelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}