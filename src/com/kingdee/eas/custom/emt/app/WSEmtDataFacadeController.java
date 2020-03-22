package com.kingdee.eas.custom.emt.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSEmtDataFacadeController extends BizController
{
    public String getUserFeedInfo(Context ctx, String lastUpdateDate) throws BOSException, RemoteException;
    public String getUserFeedBatchInfo(Context ctx, String lastUpdateTime) throws BOSException, RemoteException;
    public String getUserInComeInfo(Context ctx, String lastUpdateTime) throws BOSException, RemoteException;
    public String getUserPayInfo(Context ctx, String lastUpdateTime) throws BOSException, RemoteException;
}