package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IStockingDaily extends ICoreBillBase
{
    public StockingDailyCollection getStockingDailyCollection() throws BOSException;
    public StockingDailyCollection getStockingDailyCollection(EntityViewInfo view) throws BOSException;
    public StockingDailyCollection getStockingDailyCollection(String oql) throws BOSException;
    public StockingDailyInfo getStockingDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingDailyInfo getStockingDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingDailyInfo getStockingDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(StockingDailyInfo model) throws BOSException, EASBizException;
    public void unAudit(StockingDailyInfo model) throws BOSException, EASBizException;
    public List genNextBill(StockingDailyInfo model) throws BOSException;
    public void reShareCoalAndDiesel(StockingDailyInfo model) throws BOSException;
    public String recalStockingByBatchID(String String) throws BOSException, EASBizException;
}