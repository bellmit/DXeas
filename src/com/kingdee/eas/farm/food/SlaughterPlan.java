package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SlaughterPlan extends CoreBillBase implements ISlaughterPlan
{
    public SlaughterPlan()
    {
        super();
        registerInterface(ISlaughterPlan.class, this);
    }
    public SlaughterPlan(Context ctx)
    {
        super(ctx);
        registerInterface(ISlaughterPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C95AD0D2");
    }
    private SlaughterPlanController getController() throws BOSException
    {
        return (SlaughterPlanController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SlaughterPlanCollection getSlaughterPlanCollection() throws BOSException
    {
        try {
            return getController().getSlaughterPlanCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public SlaughterPlanCollection getSlaughterPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSlaughterPlanCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public SlaughterPlanCollection getSlaughterPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getSlaughterPlanCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SlaughterPlanInfo getSlaughterPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public SlaughterPlanInfo getSlaughterPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public SlaughterPlanInfo getSlaughterPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ���׼ƻ�-User defined method
     *@param model model
     */
    public void getSlaughterPlan(SlaughterPlanInfo model) throws BOSException
    {
        try {
            getController().getSlaughterPlan(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(SlaughterPlanInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(SlaughterPlanInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ˢ��-User defined method
     *@param model model
     */
    public void refresh(SlaughterPlanInfo model) throws BOSException
    {
        try {
            getController().refresh(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}