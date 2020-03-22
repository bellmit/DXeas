package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.math.BigDecimal;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface weightbridgeFacadeController extends BizController
{
    public Map getPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException, RemoteException;
    public Map getSaleorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException, RemoteException;
    public void updateInweightSourceBillInfo(Context ctx, InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo, BigDecimal newGrossWeight, BigDecimal newTare) throws BOSException, RemoteException;
    public Map getCarSendTara(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException, RemoteException;
    public Map getNewPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException, RemoteException;
    public Map getQCInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException, RemoteException;
}