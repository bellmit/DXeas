package com.kingdee.eas.custom.settleaccount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.settleaccount.util.CheckResultInfo;
import com.kingdee.eas.custom.settleaccount.app.*;
import com.kingdee.bos.util.*;

public class settleAccountFacade extends AbstractBizCtrl implements IsettleAccountFacade
{
    public settleAccountFacade()
    {
        super();
        registerInterface(IsettleAccountFacade.class, this);
    }
    public settleAccountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsettleAccountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6059DDEB");
    }
    private settleAccountFacadeController getController() throws BOSException
    {
        return (settleAccountFacadeController)getBizController();
    }
    /**
     *receivingBillCheck-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo receivingBillCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().receivingBillCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *付款单校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo paymentBillCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().paymentBillCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *采购入库未生成凭证校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo purInWarehsBillCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().purInWarehsBillCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *固定资产未生成凭证校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo faCurCardCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().faCurCardCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *低值易耗品生成凭证校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo LCMCurCardCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().LCMCurCardCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *采购入库实际成本为0校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo purInWarehsACost0Check(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().purInWarehsACost0Check(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *销售订单未关闭状态校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo saleOrderNotCloseCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().saleOrderNotCloseCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *销售出库单未生成应收单校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo saleIssueBillNoOtherBillCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().saleIssueBillNoOtherBillCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *领料出库成本中心返工标识对应校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo materialReqCCReWorkCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().materialReqCCReWorkCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *领料出库状态为非审核-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo materialReqNotAuditCheck(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().materialReqNotAuditCheck(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *其他出库单成本中心非生产一部校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo otherIssueCCenterNot1Check(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().otherIssueCCenterNot1Check(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *其他出库单实际成本为0校验-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     *@return
     */
    public CheckResultInfo otherIssueACost0Check(String companyID, String periodID) throws BOSException
    {
        try {
            return getController().otherIssueACost0Check(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}