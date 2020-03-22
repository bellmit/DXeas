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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AssessmentMeasureEntry extends CoreBillEntryBase implements IAssessmentMeasureEntry
{
    public AssessmentMeasureEntry()
    {
        super();
        registerInterface(IAssessmentMeasureEntry.class, this);
    }
    public AssessmentMeasureEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAssessmentMeasureEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EBC6DD18");
    }
    private AssessmentMeasureEntryController getController() throws BOSException
    {
        return (AssessmentMeasureEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AssessmentMeasureEntryInfo getAssessmentMeasureEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureEntryInfo(getContext(), pk);
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
    public AssessmentMeasureEntryInfo getAssessmentMeasureEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureEntryInfo(getContext(), pk, selector);
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
    public AssessmentMeasureEntryInfo getAssessmentMeasureEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAssessmentMeasureEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AssessmentMeasureEntryCollection getAssessmentMeasureEntryCollection() throws BOSException
    {
        try {
            return getController().getAssessmentMeasureEntryCollection(getContext());
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
    public AssessmentMeasureEntryCollection getAssessmentMeasureEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAssessmentMeasureEntryCollection(getContext(), view);
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
    public AssessmentMeasureEntryCollection getAssessmentMeasureEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAssessmentMeasureEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}