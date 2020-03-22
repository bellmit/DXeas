package com.kingdee.eas.custom.salegrossprofitsrpt.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.report.app.CommRptBaseController;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SaleGrossProfitsController extends CommRptBaseController
{
    public int getMaxCustomerLevel(Context ctx) throws BOSException, RemoteException;
    public int getMaxMaterialLevel(Context ctx) throws BOSException, RemoteException;
    public int[] getMaxLevels(Context ctx) throws BOSException, RemoteException;
    public IRowSet getQueryResultByParams(Context ctx, RptParams rptparams) throws BOSException, EASBizException, RemoteException;
    public RptParams createTempTable(Context ctx, RptParams RptParams) throws BOSException, EASBizException, RemoteException;
}