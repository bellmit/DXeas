package com.kingdee.eas.farm.dayratecost;

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

public interface IDayRateInitBill extends ICoreBillBase
{
    public DayRateInitBillCollection getDayRateInitBillCollection() throws BOSException;
    public DayRateInitBillCollection getDayRateInitBillCollection(EntityViewInfo view) throws BOSException;
    public DayRateInitBillCollection getDayRateInitBillCollection(String oql) throws BOSException;
    public DayRateInitBillInfo getDayRateInitBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DayRateInitBillInfo getDayRateInitBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DayRateInitBillInfo getDayRateInitBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(DayRateInitBillInfo model) throws BOSException;
    public void unAudit(DayRateInitBillInfo model) throws BOSException;
    public void initialize(DayRateInitBillInfo model) throws BOSException, EASBizException;
    public void unInitialize(DayRateInitBillInfo model) throws BOSException, EASBizException;
}