package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IMonthBillFarm extends ICoreBillBase
{
    public MonthBillFarmCollection getMonthBillFarmCollection() throws BOSException;
    public MonthBillFarmCollection getMonthBillFarmCollection(EntityViewInfo view) throws BOSException;
    public MonthBillFarmCollection getMonthBillFarmCollection(String oql) throws BOSException;
    public MonthBillFarmInfo getMonthBillFarmInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MonthBillFarmInfo getMonthBillFarmInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MonthBillFarmInfo getMonthBillFarmInfo(String oql) throws BOSException, EASBizException;
    public void audit(MonthBillFarmInfo model) throws BOSException;
    public void unaudit(MonthBillFarmInfo model) throws BOSException;
    public void getPerson(MonthBillFarmInfo model) throws BOSException;
    public void wagecalculation(MonthBillFarmInfo model) throws BOSException;
}