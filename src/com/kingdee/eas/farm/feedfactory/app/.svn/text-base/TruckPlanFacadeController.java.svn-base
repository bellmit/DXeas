package com.kingdee.eas.farm.feedfactory.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TruckPlanFacadeController extends BizController
{
    public List getFodderPlandetails(Context ctx, Date planDate) throws BOSException, RemoteException;
    public FeedFactoryBaseDataInfo getFeedFactoryBaseData(Context ctx) throws BOSException, RemoteException;
    public Map getDistanseSetinfo(Context ctx) throws BOSException, RemoteException;
}