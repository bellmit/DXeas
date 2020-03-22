package com.kingdee.eas.custom.salegrossprofitsrpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.framework.report.CommRptBase;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.custom.salegrossprofitsrpt.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class SaleGrossProfits extends CommRptBase implements ISaleGrossProfits
{
    public SaleGrossProfits()
    {
        super();
        registerInterface(ISaleGrossProfits.class, this);
    }
    public SaleGrossProfits(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleGrossProfits.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8A092EA1");
    }
    private SaleGrossProfitsController getController() throws BOSException
    {
        return (SaleGrossProfitsController)getBizController();
    }
    /**
     *��ȡ�ͻ�������󼶴�-User defined method
     *@return
     */
    public int getMaxCustomerLevel() throws BOSException
    {
        try {
            return getController().getMaxCustomerLevel(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ�������ϼ���-User defined method
     *@return
     */
    public int getMaxMaterialLevel() throws BOSException
    {
        try {
            return getController().getMaxMaterialLevel(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ������Ϳͻ�����󼶱�-User defined method
     *@return
     */
    public int[] getMaxLevels() throws BOSException
    {
        try {
            return getController().getMaxLevels(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ǰ̨�����������ѯ�����ؽ��-User defined method
     *@param rptparams �������
     *@return
     */
    public IRowSet getQueryResultByParams(RptParams rptparams) throws BOSException, EASBizException
    {
        try {
            return getController().getQueryResultByParams(getContext(), rptparams);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *createTempTable-User defined method
     *@param RptParams �������
     *@return
     */
    public RptParams createTempTable(RptParams RptParams) throws BOSException, EASBizException
    {
        try {
            return getController().createTempTable(getContext(), RptParams);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}