package com.kingdee.eas.wlhlcomm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ToolFacadeController extends BizController
{
    public void execute(Context ctx, String sql) throws BOSException, RemoteException;
    public IRowSet executeQuery(Context ctx, String sql) throws BOSException, RemoteException;
    public void execute(Context ctx, String sql, Object[] params) throws BOSException, RemoteException;
    public IRowSet executeQuery(Context ctx, String sql, Object[] params) throws BOSException, RemoteException;
    public MaterialBasePriceInfo getMaterialBasePrice(Context ctx, String adminCUID, String priceTypeID, String materialID, String unitID, String currencyID) throws BOSException, RemoteException;
    public List getEnableJobs(Context ctx, String jobName) throws BOSException, RemoteException;
    public List getJobByNames(Context ctx, String[] jobNames) throws BOSException, RemoteException;
    public RptParams getInOutStoreGatherParam(Context ctx, String stoorgID, String warehouseID, Date beginDate, Date endDate, String matid) throws BOSException, RemoteException;
    public RptParams getInOutStoreGatherParamArray(Context ctx, StorageOrgUnitInfo[] stoArray, String wareid, Date beginDate, Date endDate, String matid) throws BOSException, RemoteException;
}