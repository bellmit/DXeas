package com.kingdee.eas.custom.settleaccount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.settleaccount.util.CheckResultInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface settleAccountFacadeController extends BizController
{
    public CheckResultInfo receivingBillCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo paymentBillCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo purInWarehsBillCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo faCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo LCMCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo purInWarehsACost0Check(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo saleOrderNotCloseCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo saleIssueBillNoOtherBillCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo materialReqCCReWorkCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo materialReqNotAuditCheck(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo otherIssueCCenterNot1Check(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
    public CheckResultInfo otherIssueACost0Check(Context ctx, String companyID, String periodID) throws BOSException, RemoteException;
}