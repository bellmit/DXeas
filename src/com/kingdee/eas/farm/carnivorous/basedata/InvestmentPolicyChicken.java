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

public class InvestmentPolicyChicken extends DataBase implements IInvestmentPolicyChicken
{
    public InvestmentPolicyChicken()
    {
        super();
        registerInterface(IInvestmentPolicyChicken.class, this);
    }
    public InvestmentPolicyChicken(Context ctx)
    {
        super(ctx);
        registerInterface(IInvestmentPolicyChicken.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3826E82E");
    }
    private InvestmentPolicyChickenController getController() throws BOSException
    {
        return (InvestmentPolicyChickenController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyChickenInfo(getContext(), pk);
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
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyChickenInfo(getContext(), pk, selector);
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
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyChickenInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection() throws BOSException
    {
        try {
            return getController().getInvestmentPolicyChickenCollection(getContext());
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
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInvestmentPolicyChickenCollection(getContext(), view);
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
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection(String oql) throws BOSException
    {
        try {
            return getController().getInvestmentPolicyChickenCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(InvestmentPolicyChickenInfo model) throws BOSException, EASBizException
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
    public void unAudit(InvestmentPolicyChickenInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}