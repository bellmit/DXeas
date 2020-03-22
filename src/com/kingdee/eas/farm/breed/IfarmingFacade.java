package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IfarmingFacade extends IBizCtrl
{
    public ArrayList getBreedPlan(Date date, PeriodInfo period, StorageOrgUnitInfo stoOrgUnit, String planType) throws BOSException;
    public ArrayList getSlaughterPlan(StorageOrgUnitInfo storageUnit, PeriodInfo period) throws BOSException;
}