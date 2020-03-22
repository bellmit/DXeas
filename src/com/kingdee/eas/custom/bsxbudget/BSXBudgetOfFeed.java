package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.bsxbudget.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BSXBudgetOfFeed extends CoreBillBase implements IBSXBudgetOfFeed
{
    public BSXBudgetOfFeed()
    {
        super();
        registerInterface(IBSXBudgetOfFeed.class, this);
    }
    public BSXBudgetOfFeed(Context ctx)
    {
        super(ctx);
        registerInterface(IBSXBudgetOfFeed.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("92F4601A");
    }
    private BSXBudgetOfFeedController getController() throws BOSException
    {
        return (BSXBudgetOfFeedController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection() throws BOSException
    {
        try {
            return getController().getBSXBudgetOfFeedCollection(getContext());
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
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBSXBudgetOfFeedCollection(getContext(), view);
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
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection(String oql) throws BOSException
    {
        try {
            return getController().getBSXBudgetOfFeedCollection(getContext(), oql);
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
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetOfFeedInfo(getContext(), pk);
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
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetOfFeedInfo(getContext(), pk, selector);
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
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetOfFeedInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ��������-User defined method
     *@param model model
     */
    public void getLairageQty(BSXBudgetOfFeedInfo model) throws BOSException
    {
        try {
            getController().getLairageQty(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(BSXBudgetOfFeedInfo model) throws BOSException, EASBizException
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
    public void unAudit(BSXBudgetOfFeedInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}