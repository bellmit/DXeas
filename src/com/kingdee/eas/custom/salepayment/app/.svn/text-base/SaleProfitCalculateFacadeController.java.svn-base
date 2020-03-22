package com.kingdee.eas.custom.salepayment.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salepayment.SalePaymentSetInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SaleProfitCalculateFacadeController extends BizController
{
    public ResultInfo calculateCompanyTarget(Context ctx, String companyID, String companyTargetID) throws BOSException, RemoteException;
    public IObjectCollection getSalerTargetInfos(Context ctx, String companyTargetID) throws BOSException, RemoteException;
    public SalePaymentSetInfo getCompanySetInfo(Context ctx, String companyID) throws BOSException, RemoteException;
    public HashMap getCompanyStandardCost(Context ctx, String companyID, int year) throws BOSException, RemoteException;
}