package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ItraceFacade extends IBizCtrl
{
    public String getBatchDetailInfos(String batchNumber) throws BOSException;
    public List getBatchHatchBills(BreedBatchInfo batchInfo) throws BOSException;
}