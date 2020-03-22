package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;
import com.kingdee.bos.util.*;

public interface ICCPigFacade extends IBizCtrl
{
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(String farmID, Date bizDate) throws BOSException;
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(String farmID, String batchID, Date bizDate) throws BOSException;
    public CCPigBreedModelInfo getAvailableBreedModel(Date bizDate, String farmID) throws BOSException;
    public CCPigBreedModelEntryInfo getModelBreedEntryInfo(CCPigBreedModelInfo modelInfo, int days) throws BOSException;
    public List getModelImmunePlans(CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException;
    public List getModelRecentImmunePlans(CCPigBreedModelInfo modelInfo, Date bizDate, int batchDays) throws BOSException;
}