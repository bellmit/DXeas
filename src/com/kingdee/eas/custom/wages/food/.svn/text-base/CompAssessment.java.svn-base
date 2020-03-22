package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompAssessment extends DataBase implements ICompAssessment
{
    public CompAssessment()
    {
        super();
        registerInterface(ICompAssessment.class, this);
    }
    public CompAssessment(Context ctx)
    {
        super(ctx);
        registerInterface(ICompAssessment.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("59E964B3");
    }
    private CompAssessmentController getController() throws BOSException
    {
        return (CompAssessmentController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompAssessmentInfo getCompAssessmentInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompAssessmentInfo(getContext(), pk);
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
    public CompAssessmentInfo getCompAssessmentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompAssessmentInfo(getContext(), pk, selector);
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
    public CompAssessmentInfo getCompAssessmentInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompAssessmentInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompAssessmentCollection getCompAssessmentCollection() throws BOSException
    {
        try {
            return getController().getCompAssessmentCollection(getContext());
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
    public CompAssessmentCollection getCompAssessmentCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompAssessmentCollection(getContext(), view);
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
    public CompAssessmentCollection getCompAssessmentCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompAssessmentCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}