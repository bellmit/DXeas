package com.kingdee.eas.wlhlcomm.app;

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

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SalePriceFacadeController extends BizController
{
    public BigDecimal getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDateStr, BigDecimal orderQty, String unitID) throws BOSException, RemoteException;
    public BigDecimal getMaterialBasePrice(Context ctx, String adminCUid, String materialID, String unitID) throws BOSException, RemoteException;
}