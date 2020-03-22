package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.DeliveryCarInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DeliveryCarEditFacadeController extends BizController
{
    public DeliveryCarInfo getDeliveryCarDetails(Context ctx, String carNumber) throws BOSException, RemoteException;
    public void saveOrUpdateCarInfo(Context ctx, DeliveryCarInfo car) throws BOSException, RemoteException;
    public DeliveryCarInfo getDeliveryCarDetailsByPersonName(Context ctx, String personName) throws BOSException, RemoteException;
}