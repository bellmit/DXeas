package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import java.util.LinkedHashMap;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface ISlaughterPlanFacade extends IBizCtrl
{
    public LinkedHashMap getSlaughterPlan(PeriodInfo fiscalPeriod, int ageOfDaysBeginFrom, int ageOfDaysBeginTo) throws BOSException, EASBizException;
    public Map getCullAndDeathFromFeedModel() throws BOSException, EASBizException;
    public String[] getSlaughterQtyInOneDay(String sroOrgUnitID, String henHouseID, String breedBatchID) throws BOSException, EASBizException;
}