package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface parentFacadeController extends BizController
{
    public BreedStoorgSetInfo getFarmByStoOrgID(Context ctx, String stoOrgID) throws BOSException, RemoteException;
    public ParentBreedBatchDetailInfo getBreedBatchDetailInfos(Context ctx, String parentBatchID, Date bizDate) throws BOSException, RemoteException;
    public BreedModelInfo getBreedModel(Context ctx, String henhouseType, String companyID, boolean isMoulting) throws BOSException, RemoteException;
    public HashMap getBatchWeekages(Context ctx, String parentBatchID, Date bizDate) throws BOSException, RemoteException;
    public boolean isBatchFixed(Context ctx, String batchID, Date bizDate) throws BOSException, RemoteException;
    public boolean isBatchBroodFixed(Context ctx, String batchID, Date bizDate) throws BOSException, RemoteException;
}