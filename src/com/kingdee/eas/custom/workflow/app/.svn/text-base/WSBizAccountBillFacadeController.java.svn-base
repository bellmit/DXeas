package com.kingdee.eas.custom.workflow.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSBizAccountBillFacadeController extends BizController
{
    public String importBizAccountBill(Context ctx, String dataXml) throws BOSException, RemoteException;
    public String getOrgInfoByUser(Context ctx, String user) throws BOSException, RemoteException;
    public String getOrgListByUser(Context ctx, String userId) throws BOSException, RemoteException;
    public String getDeptListByCompany(Context ctx, String company) throws BOSException, RemoteException;
    public String getBizType(Context ctx, String userId) throws BOSException, RemoteException;
    public String getExpTypeByBizType(Context ctx, String bizType, String userNumber) throws BOSException, RemoteException;
    public String getBizAccountBillByAssignId(Context ctx, String assignId) throws BOSException, RemoteException;
    public String getBizAccountBillList(Context ctx, String dataJson) throws BOSException, RemoteException;
}