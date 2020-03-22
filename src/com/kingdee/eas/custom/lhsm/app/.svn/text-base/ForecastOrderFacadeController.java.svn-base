package com.kingdee.eas.custom.lhsm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ForecastOrderFacadeController extends BizController
{
    public IRowSet getSqlData(Context ctx, String sql) throws BOSException, EASBizException, RemoteException;
    public String[] transToOrder(Context ctx, String forecastId, String storageOrgId, String currOrgUnitId) throws BOSException, EASBizException, RemoteException;
    public String[] rejectForecast(Context ctx, String forecasId) throws BOSException, EASBizException, RemoteException;
    public boolean execSql(Context ctx, String sql) throws BOSException, RemoteException;
    public void saleorder(Context ctx, String id) throws BOSException, RemoteException;
    public void companyInv(Context ctx, String cuid, String materialid) throws BOSException, RemoteException;
    public void addSaleForecast(Context ctx) throws BOSException, RemoteException;
    public void updateSaleForecast(Context ctx, String id) throws BOSException, RemoteException;
    public void exportData(Context ctx, String cuid, int type, String fid, String fstatus) throws BOSException, RemoteException;
    public String downloadBillData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String uploadBillData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String downloadBillList(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String getOrgUnitRangeByUserNum(Context ctx, String parma) throws BOSException, RemoteException;
    public String getMaterialByOrg(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String createNewForecastOrder(Context ctx, String param) throws BOSException, RemoteException;
    public String getPaymentType(Context ctx, String param) throws BOSException, RemoteException;
    public String getCustomerBySaleOrg(Context ctx, String param) throws BOSException, RemoteException;
    public String getSaleGroupBySaleOrg(Context ctx, String param) throws BOSException, RemoteException;
    public String getSalePerson(Context ctx, String param) throws BOSException, RemoteException;
    public String getForecastDetailInfo(Context ctx, String param) throws BOSException, RemoteException;
    public String getMaterialPrice(Context ctx, String param) throws BOSException, RemoteException;
    public String getWareHouseList(Context ctx, String param) throws BOSException, RemoteException;
    public String getSalePersonOrgUnitRange(Context ctx, String param) throws BOSException, RemoteException;
    public String getSaleForecastBillPro(Context ctx, String param) throws BOSException, RemoteException;
}