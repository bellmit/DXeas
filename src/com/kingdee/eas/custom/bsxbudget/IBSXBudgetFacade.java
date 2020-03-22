package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IBSXBudgetFacade extends IBizCtrl
{
    public PeriodInfo getCurrentPeriod() throws BOSException;
    public String[] getInventoryValue(PeriodInfo period) throws BOSException;
    public BigDecimal getTotalWeightFromBugetFeed(PeriodInfo periodInfo) throws BOSException;
    public BigDecimal getLairageQty(String beginDate, String endDate) throws BOSException;
}