package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.bsxbudget.app.*;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class BSXBudgetFacade extends AbstractBizCtrl implements IBSXBudgetFacade
{
    public BSXBudgetFacade()
    {
        super();
        registerInterface(IBSXBudgetFacade.class, this);
    }
    public BSXBudgetFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBSXBudgetFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("835F6C9F");
    }
    private BSXBudgetFacadeController getController() throws BOSException
    {
        return (BSXBudgetFacadeController)getBizController();
    }
    /**
     *��õ�ǰ����ڼ�-User defined method
     *@return
     */
    public PeriodInfo getCurrentPeriod() throws BOSException
    {
        try {
            return getController().getCurrentPeriod(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����³��Ŀ���ֵ-User defined method
     *@param period ����ڼ�
     *@return
     */
    public String[] getInventoryValue(PeriodInfo period) throws BOSException
    {
        try {
            return getController().getInventoryValue(getContext(), period);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ֳ�ӻ���ȡë������-User defined method
     *@param periodInfo ����ڼ�
     *@return
     */
    public BigDecimal getTotalWeightFromBugetFeed(PeriodInfo periodInfo) throws BOSException
    {
        try {
            return getController().getTotalWeightFromBugetFeed(getContext(), periodInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���������-User defined method
     *@param beginDate ������ʼ����
     *@param endDate ������������
     *@return
     */
    public BigDecimal getLairageQty(String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getLairageQty(getContext(), beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}