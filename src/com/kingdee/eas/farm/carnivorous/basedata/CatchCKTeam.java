package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class CatchCKTeam extends DataBase implements ICatchCKTeam
{
    public CatchCKTeam()
    {
        super();
        registerInterface(ICatchCKTeam.class, this);
    }
    public CatchCKTeam(Context ctx)
    {
        super(ctx);
        registerInterface(ICatchCKTeam.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0477F67E");
    }
    private CatchCKTeamController getController() throws BOSException
    {
        return (CatchCKTeamController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CatchCKTeamInfo getCatchCKTeamInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCatchCKTeamInfo(getContext(), pk);
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
    public CatchCKTeamInfo getCatchCKTeamInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCatchCKTeamInfo(getContext(), pk, selector);
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
    public CatchCKTeamInfo getCatchCKTeamInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCatchCKTeamInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CatchCKTeamCollection getCatchCKTeamCollection() throws BOSException
    {
        try {
            return getController().getCatchCKTeamCollection(getContext());
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
    public CatchCKTeamCollection getCatchCKTeamCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCatchCKTeamCollection(getContext(), view);
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
    public CatchCKTeamCollection getCatchCKTeamCollection(String oql) throws BOSException
    {
        try {
            return getController().getCatchCKTeamCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(CatchCKTeamInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(CatchCKTeamInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}