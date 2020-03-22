package com.kingdee.eas.farm.food.app;

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

public interface WSFoodFacadeController extends BizController
{
    public String uploadBill(Context ctx, String jsonString) throws BOSException, RemoteException;
    public String getBaseData(Context ctx, String jsonStr) throws BOSException, RemoteException;
    public String getBillList(Context ctx, String jsonString) throws BOSException, RemoteException;
    public String getBillInfo(Context ctx, String jsonString) throws BOSException, RemoteException;
}