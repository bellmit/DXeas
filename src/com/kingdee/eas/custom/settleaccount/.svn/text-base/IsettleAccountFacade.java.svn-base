package com.kingdee.eas.custom.settleaccount;

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

public interface IsettleAccountFacade extends IBizCtrl
{
    public CheckResultInfo receivingBillCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo paymentBillCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo purInWarehsBillCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo faCurCardCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo LCMCurCardCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo purInWarehsACost0Check(String companyID, String periodID) throws BOSException;
    public CheckResultInfo saleOrderNotCloseCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo saleIssueBillNoOtherBillCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo materialReqCCReWorkCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo materialReqNotAuditCheck(String companyID, String periodID) throws BOSException;
    public CheckResultInfo otherIssueCCenterNot1Check(String companyID, String periodID) throws BOSException;
    public CheckResultInfo otherIssueACost0Check(String companyID, String periodID) throws BOSException;
}