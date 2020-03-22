package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.math.BigDecimal;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IweightbridgeFacade extends IBizCtrl
{
    public Map getPurorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException;
    public Map getSaleorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException;
    public void updateInweightSourceBillInfo(InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo, BigDecimal newGrossWeight, BigDecimal newTare) throws BOSException;
    public Map getCarSendTara(String number, String carNumber, String beginDate, String endDate) throws BOSException;
    public Map getNewPurorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException;
    public Map getQCInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException;
}