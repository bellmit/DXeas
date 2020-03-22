package com.kingdee.eas.WSInterface.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.fi.gl.WSVoucherCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSInterfaceFacadeController extends BizController
{
    public String getBaseData(Context ctx, String queryStr) throws BOSException, RemoteException;
    public String importVoucher(Context ctx, WSVoucherCollection col, int isVerify, int isCashflow) throws BOSException, RemoteException;
    public String importBill(Context ctx, String BosType, String BillJSON, int BillStatus) throws BOSException, RemoteException;
    public String getVoucher(Context ctx, String orgNumber, String year, String period, int fromRow, int toRow) throws BOSException, RemoteException;
    public String findVoucher(Context ctx, String orgNumber, int year, int period) throws BOSException, RemoteException;
    public String ImpBaseData(Context ctx, String billType, String JSON, int billStatus) throws BOSException, RemoteException;
    public String getBaseDataByOrgNum(Context ctx, String queryStr) throws BOSException, RemoteException;
    public String getVoucher(Context ctx, String OrgUnitID, String year, String period, String numbers) throws BOSException, RemoteException;
}