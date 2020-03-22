package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IBroodDaily extends ICoreBillBase
{
    public BroodDailyCollection getBroodDailyCollection() throws BOSException;
    public BroodDailyCollection getBroodDailyCollection(EntityViewInfo view) throws BOSException;
    public BroodDailyCollection getBroodDailyCollection(String oql) throws BOSException;
    public BroodDailyInfo getBroodDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BroodDailyInfo getBroodDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BroodDailyInfo getBroodDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(BroodDailyInfo model) throws BOSException;
    public void unAudit(BroodDailyInfo model) throws BOSException;
    public List genNextBill(BroodDailyInfo model) throws BOSException;
    public void reShareCoalAndDiesel(BroodDailyInfo model) throws BOSException;
}