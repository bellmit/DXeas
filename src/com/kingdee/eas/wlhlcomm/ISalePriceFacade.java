package com.kingdee.eas.wlhlcomm;

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
import com.kingdee.bos.util.*;

public interface ISalePriceFacade extends IBizCtrl
{
    public BigDecimal getMaterialPolicyPrice(String companyID, String customerID, String materialID, String bizDateStr, BigDecimal orderQty, String unitID) throws BOSException;
    public BigDecimal getMaterialBasePrice(String adminCUid, String materialID, String unitID) throws BOSException;
}