package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import java.util.List;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.HenhouseType;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface ICCProductPlanRptCommonFacade extends IBizCtrl
{
    public List getRptBeanStorageInfos(HashMap param) throws BOSException;
    public List getStoorgPlanInfo(CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException;
    public List getStoorgBatchInfo(CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException;
    public BreedModelInfo getCurrentBreedModelInfo(HenhouseType houseType) throws BOSException;
    public int getCCPredateHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException;
    public int getCCActualOutHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException;
}