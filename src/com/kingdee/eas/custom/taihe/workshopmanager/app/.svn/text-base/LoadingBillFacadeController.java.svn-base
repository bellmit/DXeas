package com.kingdee.eas.custom.taihe.workshopmanager.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LoadingBillFacadeController extends BizController
{
    public String downloadData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String uploadData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String queryData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String create2SaleIssure(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public String finishLoading(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String deleteData(Context ctx, String jsonStr) throws BOSException, RemoteException;
}