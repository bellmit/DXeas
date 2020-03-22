package com.kingdee.eas.wlhlcomm;

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

public interface IToolFacade extends IBizCtrl
{
    public void execute(String sql) throws BOSException;
    public IRowSet executeQuery(String sql) throws BOSException;
    public void execute(String sql, Object[] params) throws BOSException;
    public IRowSet executeQuery(String sql, Object[] params) throws BOSException;
    public MaterialBasePriceInfo getMaterialBasePrice(String adminCUID, String priceTypeID, String materialID, String unitID, String currencyID) throws BOSException;
    public List getEnableJobs(String jobName) throws BOSException;
    public List getJobByNames(String[] jobNames) throws BOSException;
    public RptParams getInOutStoreGatherParam(String stoorgID, String warehouseID, Date beginDate, Date endDate, String matid) throws BOSException;
    public RptParams getInOutStoreGatherParamArray(StorageOrgUnitInfo[] stoArray, String wareid, Date beginDate, Date endDate, String matid) throws BOSException;
}