package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.bos.util.*;

public interface ISaleDiscountFacade extends IBizCtrl
{
    public CustomerBalanceInfo getCustomerBalanceInfo(String companyID, String customerID) throws BOSException;
    public ResultInfo updateCustomerBalance(String companyID, String customerID, BigDecimal substractAmount, BigDecimal addAmount) throws BOSException;
    public ResultInfo recountCustomerBalance(String companyID, String customerID) throws BOSException;
}