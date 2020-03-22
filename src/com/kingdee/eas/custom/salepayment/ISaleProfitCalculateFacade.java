package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.bos.util.*;

public interface ISaleProfitCalculateFacade extends IBizCtrl
{
    public ResultInfo calculateCompanyTarget(String companyID, String companyTargetID) throws BOSException;
    public IObjectCollection getSalerTargetInfos(String companyTargetID) throws BOSException;
    public SalePaymentSetInfo getCompanySetInfo(String companyID) throws BOSException;
    public HashMap getCompanyStandardCost(String companyID, int year) throws BOSException;
}