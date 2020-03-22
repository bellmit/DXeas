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

public interface IDayRateCostDetail extends ICoreBillBase
{
    public DayRateCostDetailCollection getDayRateCostDetailCollection() throws BOSException;
    public DayRateCostDetailCollection getDayRateCostDetailCollection(EntityViewInfo view) throws BOSException;
    public DayRateCostDetailCollection getDayRateCostDetailCollection(String oql) throws BOSException;
    public DayRateCostDetailInfo getDayRateCostDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DayRateCostDetailInfo getDayRateCostDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DayRateCostDetailInfo getDayRateCostDetailInfo(String oql) throws BOSException, EASBizException;
    public void audit(DayRateCostDetailInfo model) throws BOSException;
    public void unAudit(DayRateCostDetailInfo model) throws BOSException;
}