package com.kingdee.eas.custom.settlebill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettleBillFacdeController extends BizController
{
    public String[] importData(Context ctx, String xml) throws BOSException, RemoteException;
    public Map getCostAmtOfMLY(Context ctx, CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) throws BOSException, RemoteException;
    public boolean updateVoucherFlag(Context ctx, String sqlStr) throws BOSException, EASBizException, RemoteException;
}