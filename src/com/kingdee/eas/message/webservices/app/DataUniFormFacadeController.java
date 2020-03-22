package com.kingdee.eas.message.webservices.app;

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

public interface DataUniFormFacadeController extends BizController
{
    public String getDataFromJsonCondition(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String getOrderStatusFromJsonCondition(Context ctx, String jsonStr) throws BOSException, RemoteException;
}