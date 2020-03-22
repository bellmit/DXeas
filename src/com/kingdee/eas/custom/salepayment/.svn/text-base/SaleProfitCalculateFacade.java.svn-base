package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.dao.IObjectCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.bos.util.*;

public class SaleProfitCalculateFacade extends AbstractBizCtrl implements ISaleProfitCalculateFacade
{
    public SaleProfitCalculateFacade()
    {
        super();
        registerInterface(ISaleProfitCalculateFacade.class, this);
    }
    public SaleProfitCalculateFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleProfitCalculateFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7CDAA241");
    }
    private SaleProfitCalculateFacadeController getController() throws BOSException
    {
        return (SaleProfitCalculateFacadeController)getBizController();
    }
    /**
     *计算公司指标-User defined method
     *@param companyID 公司ID
     *@param companyTargetID 指标ID
     *@return
     */
    public ResultInfo calculateCompanyTarget(String companyID, String companyTargetID) throws BOSException
    {
        try {
            return getController().calculateCompanyTarget(getContext(), companyID, companyTargetID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据公司指标获得所有销售员指标-User defined method
     *@param companyTargetID companyTargetID
     *@return
     */
    public IObjectCollection getSalerTargetInfos(String companyTargetID) throws BOSException
    {
        try {
            return getController().getSalerTargetInfos(getContext(), companyTargetID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得公司的销售基本设置-User defined method
     *@param companyID 公司
     *@return
     */
    public SalePaymentSetInfo getCompanySetInfo(String companyID) throws BOSException
    {
        try {
            return getController().getCompanySetInfo(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定公司指定年度的标准成本，整理成map返回-User defined method
     *@param companyID 公司ID
     *@param year 年
     *@return
     */
    public HashMap getCompanyStandardCost(String companyID, int year) throws BOSException
    {
        try {
            return getController().getCompanyStandardCost(getContext(), companyID, year);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}