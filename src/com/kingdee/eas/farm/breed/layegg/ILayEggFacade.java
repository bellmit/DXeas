package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ILayEggFacade extends IBizCtrl
{
    public Object getHouseLayEggSet(String henhouseID) throws BOSException;
    public List getConveyors(String stoOrgID) throws BOSException;
    public Map getLayeggStandard(String henType) throws BOSException;
    public Map getFeedStandard(String henType) throws BOSException;
    public boolean isBatchFixed(String batchID, Date bizDate) throws BOSException;
    public ParentBreedBatchInfo getCurrentParentBatch(String internalFarmID, Date bizDate) throws BOSException;
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String batchID) throws BOSException;
    public void toStockDaily() throws BOSException;
}