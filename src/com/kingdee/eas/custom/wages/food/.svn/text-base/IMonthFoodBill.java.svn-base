package com.kingdee.eas.custom.wages.food;

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

public interface IMonthFoodBill extends ICoreBillBase
{
    public MonthFoodBillCollection getMonthFoodBillCollection() throws BOSException;
    public MonthFoodBillCollection getMonthFoodBillCollection(EntityViewInfo view) throws BOSException;
    public MonthFoodBillCollection getMonthFoodBillCollection(String oql) throws BOSException;
    public MonthFoodBillInfo getMonthFoodBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MonthFoodBillInfo getMonthFoodBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MonthFoodBillInfo getMonthFoodBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MonthFoodBillInfo model) throws BOSException;
    public void unaudit(MonthFoodBillInfo model) throws BOSException;
    public void getPerson(MonthFoodBillInfo model) throws BOSException;
    public void wagecalculation(MonthFoodBillInfo model) throws BOSException;
}