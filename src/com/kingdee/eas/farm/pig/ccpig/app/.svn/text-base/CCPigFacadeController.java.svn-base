package com.kingdee.eas.farm.pig.ccpig.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryInfo;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CCPigFacadeController extends BizController
{
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(Context ctx, String farmID, Date bizDate) throws BOSException, RemoteException;
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(Context ctx, String farmID, String batchID, Date bizDate) throws BOSException, RemoteException;
    public CCPigBreedModelInfo getAvailableBreedModel(Context ctx, Date bizDate, String farmID) throws BOSException, RemoteException;
    public CCPigBreedModelEntryInfo getModelBreedEntryInfo(Context ctx, CCPigBreedModelInfo modelInfo, int days) throws BOSException, RemoteException;
    public List getModelImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException, RemoteException;
    public List getModelRecentImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int batchDays) throws BOSException, RemoteException;
}