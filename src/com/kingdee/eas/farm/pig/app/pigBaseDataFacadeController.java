package com.kingdee.eas.farm.pig.app;

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
import com.kingdee.eas.farm.pig.PigFarmInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface pigBaseDataFacadeController extends BizController
{
    public PigFarmInfo getPigfarm(Context ctx, String stoOrgID) throws BOSException, RemoteException;
    public List getDailyImmunePlans(Context ctx, String pigFarmType, Date bizDate) throws BOSException, RemoteException;
}