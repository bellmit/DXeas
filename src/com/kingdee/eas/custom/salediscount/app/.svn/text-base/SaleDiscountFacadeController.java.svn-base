package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.eas.custom.salediscount.CustomerBalanceInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SaleDiscountFacadeController extends BizController
{
    public CustomerBalanceInfo getCustomerBalanceInfo(Context ctx, String companyID, String customerID) throws BOSException, RemoteException;
    public ResultInfo updateCustomerBalance(Context ctx, String companyID, String customerID, BigDecimal substractAmount, BigDecimal addAmount) throws BOSException, RemoteException;
    public ResultInfo recountCustomerBalance(Context ctx, String companyID, String customerID) throws BOSException, RemoteException;
}