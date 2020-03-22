package com.kingdee.eas.custom.settlebill;

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

public interface ISettleBillFacde extends IBizCtrl
{
    public String[] importData(String xml) throws BOSException;
    public Map getCostAmtOfMLY(CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) throws BOSException;
    public boolean updateVoucherFlag(String sqlStr) throws BOSException, EASBizException;
}