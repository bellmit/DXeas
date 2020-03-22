package com.kingdee.eas.custom.salegrossprofitsrpt;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface ISaleGrossProfits extends ICommRptBase
{
    public int getMaxCustomerLevel() throws BOSException;
    public int getMaxMaterialLevel() throws BOSException;
    public int[] getMaxLevels() throws BOSException;
    public IRowSet getQueryResultByParams(RptParams rptparams) throws BOSException, EASBizException;
    public RptParams createTempTable(RptParams RptParams) throws BOSException, EASBizException;
}