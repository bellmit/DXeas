package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.app.WebServiceFacadeController;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSStockingBreedDailyFacadeController extends WebServiceFacadeController
{
    public String getDailyInitBillInfo(Context ctx, String param) throws BOSException, RemoteException;
}