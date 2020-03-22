package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ScoreStandard extends DataBase implements IScoreStandard
{
    public ScoreStandard()
    {
        super();
        registerInterface(IScoreStandard.class, this);
    }
    public ScoreStandard(Context ctx)
    {
        super(ctx);
        registerInterface(IScoreStandard.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C7C98067");
    }
    private ScoreStandardController getController() throws BOSException
    {
        return (ScoreStandardController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ScoreStandardInfo getScoreStandardInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getScoreStandardInfo(getContext(), pk);
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
    public ScoreStandardInfo getScoreStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getScoreStandardInfo(getContext(), pk, selector);
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
    public ScoreStandardInfo getScoreStandardInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getScoreStandardInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ScoreStandardCollection getScoreStandardCollection() throws BOSException
    {
        try {
            return getController().getScoreStandardCollection(getContext());
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
    public ScoreStandardCollection getScoreStandardCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getScoreStandardCollection(getContext(), view);
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
    public ScoreStandardCollection getScoreStandardCollection(String oql) throws BOSException
    {
        try {
            return getController().getScoreStandardCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void approve(ScoreStandardInfo model) throws BOSException
    {
        try {
            getController().approve(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unApprove(ScoreStandardInfo model) throws BOSException
    {
        try {
            getController().unApprove(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}