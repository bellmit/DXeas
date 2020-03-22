package com.kingdee.eas.custom.lhsm;

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

public interface IForecastOrderFacade extends IBizCtrl
{
    public IRowSet getSqlData(String sql) throws BOSException, EASBizException;
    public String[] transToOrder(String forecastId, String storageOrgId, String currOrgUnitId) throws BOSException, EASBizException;
    public String[] rejectForecast(String forecasId) throws BOSException, EASBizException;
    public boolean execSql(String sql) throws BOSException;
    public void saleorder(String id) throws BOSException;
    public void companyInv(String cuid, String materialid) throws BOSException;
    public void addSaleForecast() throws BOSException;
    public void updateSaleForecast(String id) throws BOSException;
    public void exportData(String cuid, int type, String fid, String fstatus) throws BOSException;
    public String downloadBillData(String jsonStr) throws BOSException;
    public String uploadBillData(String jsonStr) throws BOSException;
    public String downloadBillList(String jsonStr) throws BOSException;
    public String getOrgUnitRangeByUserNum(String parma) throws BOSException;
    public String getMaterialByOrg(String jsonStr) throws BOSException;
    public String createNewForecastOrder(String param) throws BOSException;
    public String getPaymentType(String param) throws BOSException;
    public String getCustomerBySaleOrg(String param) throws BOSException;
    public String getSaleGroupBySaleOrg(String param) throws BOSException;
    public String getSalePerson(String param) throws BOSException;
    public String getForecastDetailInfo(String param) throws BOSException;
    public String getMaterialPrice(String param) throws BOSException;
    public String getWareHouseList(String param) throws BOSException;
    public String getSalePersonOrgUnitRange(String param) throws BOSException;
    public String getSaleForecastBillPro(String param) throws BOSException;
}