package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface ICapitalDailyRptFacade extends IBizCtrl
{
    public HashMap getCapitalDailyInfos(Date beginDate, Date endDate, String companyId) throws BOSException;
    public void releaseTempTable(String temptableName) throws BOSException;
    public HashMap getAllCompanysCapitalDailyInfos(Date beginDate, Date endDate, int isGather, String capitalType) throws BOSException;
}