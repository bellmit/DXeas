package com.kingdee.eas.farm.breed.layegg;

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

public interface ILayEggDaily extends ICoreBillBase
{
    public LayEggDailyCollection getLayEggDailyCollection() throws BOSException;
    public LayEggDailyCollection getLayEggDailyCollection(EntityViewInfo view) throws BOSException;
    public LayEggDailyCollection getLayEggDailyCollection(String oql) throws BOSException;
    public LayEggDailyInfo getLayEggDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LayEggDailyInfo getLayEggDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LayEggDailyInfo getLayEggDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(LayEggDailyInfo model) throws BOSException;
    public void unAudit(LayEggDailyInfo model) throws BOSException;
    public List genNextBill(LayEggDailyInfo model) throws BOSException;
    public void reShareInfos(LayEggDailyInfo model) throws BOSException;
    public void refreshInventory(LayEggDailyInfo model) throws BOSException;
    public void toStockDaily(LayEggDailyInfo model) throws BOSException;
}