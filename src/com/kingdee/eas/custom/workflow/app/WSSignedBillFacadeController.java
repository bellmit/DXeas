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

public interface WSSignedBillFacadeController extends BizController
{
    public String getBillType(Context ctx, String userNumber) throws BOSException, RemoteException;
    public String importBillInfo(Context ctx, String jsonData) throws BOSException, RemoteException;
    public String getBillList(Context ctx, String userNumber, String fnumber, String dateS, String dateE) throws BOSException, RemoteException;
    public String getBillInfoById(Context ctx, String fid) throws BOSException, RemoteException;
    public String getOrgInfoByUser(Context ctx, String userNumber) throws BOSException, RemoteException;
    public String getOrgListByUser(Context ctx, String userNumber) throws BOSException, RemoteException;
    public String getDeptListByCompany(Context ctx, String company) throws BOSException, RemoteException;
    public String deleteSignBillByFid(Context ctx, String fid) throws BOSException, RemoteException;
    public String getAddressesByName(Context ctx, String param) throws BOSException, RemoteException;
}