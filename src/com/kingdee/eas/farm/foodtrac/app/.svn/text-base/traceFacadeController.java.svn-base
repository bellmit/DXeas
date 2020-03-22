package com.kingdee.eas.farm.foodtrac.app;

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

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface traceFacadeController extends BizController
{
    public String getBatchDetailInfos(Context ctx, String batchNumber) throws BOSException, RemoteException;
    public List getBatchHatchBills(Context ctx, BreedBatchInfo batchInfo) throws BOSException, RemoteException;
}