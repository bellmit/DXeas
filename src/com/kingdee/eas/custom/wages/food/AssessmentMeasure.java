package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AssessmentMeasure extends CoreBillBase implements IAssessmentMeasure
{
    public AssessmentMeasure()
    {
        super();
        registerInterface(IAssessmentMeasure.class, this);
    }
    public AssessmentMeasure(Context ctx)
    {
        super(ctx);
        registerInterface(IAssessmentMeasure.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6816D77A");
    }
    private AssessmentMeasureController getController() throws BOSException
    {
        return (AssessmentMeasureController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AssessmentMeasureCollection getAssessmentMeasureCollection() throws BOSException
    {
        try {
            return getController().getAssessmentMeasureCollection(getContext());
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
    public AssessmentMeasureCollection getAssessmentMeasureCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAssessmentMeasureCollection(getContext(), view);
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
    public AssessmentMeasureCollection getAssessmentMeasureCollection(String oql) throws BOSException
    {
        try {
            return getController().getAssessmentMeasureCollection(getContext(), oql);
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
    public AssessmentMeasureInfo getAssessmentMeasureInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureInfo(getContext(), pk);
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
    public AssessmentMeasureInfo getAssessmentMeasureInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureInfo(getContext(), pk, selector);
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
    public AssessmentMeasureInfo getAssessmentMeasureInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(AssessmentMeasureInfo model) throws BOSException
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
    public void unaudit(AssessmentMeasureInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}