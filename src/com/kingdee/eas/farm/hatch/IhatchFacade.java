package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IhatchFacade extends IBizCtrl
{
    public Map getLayEggPlan(PeriodInfo period) throws BOSException;
    public HatchBaseDataInfo getHatchBaseData() throws BOSException;
    public Map getCCBreedInfo(Date pkDate) throws BOSException;
    public Map getLayEggPlanTotal(PeriodInfo period) throws BOSException;
    public HatchBaseDataInfo getHatchBaseData(StorageOrgUnitInfo stoOrg) throws BOSException;
    public void excuteSql(String sql) throws BOSException, EASBizException;
}