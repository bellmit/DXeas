package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface IparentFacade extends IBizCtrl
{
    public BreedStoorgSetInfo getFarmByStoOrgID(String stoOrgID) throws BOSException;
    public ParentBreedBatchDetailInfo getBreedBatchDetailInfos(String parentBatchID, Date bizDate) throws BOSException;
    public BreedModelInfo getBreedModel(String henhouseType, String companyID, boolean isMoulting) throws BOSException;
    public HashMap getBatchWeekages(String parentBatchID, Date bizDate) throws BOSException;
    public boolean isBatchFixed(String batchID, Date bizDate) throws BOSException;
    public boolean isBatchBroodFixed(String batchID, Date bizDate) throws BOSException;
}