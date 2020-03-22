package com.kingdee.eas.custom.eas2temp.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EAS2TempFacadeController extends BizController
{
    public String exportBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException, RemoteException;
    public String importBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException, RemoteException;
    public boolean testConn(Context ctx, String companyID, int targetSystem) throws BOSException, RemoteException;
    public String exportBillByID(Context ctx, String companyID, String billID, int sourceType) throws BOSException, RemoteException;
    public void initBarEASRel(Context ctx, String easMaterialID, String storageUnitOrgID) throws BOSException, RemoteException;
    public String deleteBarAndMyData(Context ctx, Object obj) throws BOSException, RemoteException;
    public void retryWeight(Context ctx, String PurId) throws BOSException, RemoteException;
}