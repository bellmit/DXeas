package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IStockingBreedDaily extends ICoreBillBase
{
    public StockingBreedDailyCollection getStockingBreedDailyCollection() throws BOSException;
    public StockingBreedDailyCollection getStockingBreedDailyCollection(EntityViewInfo view) throws BOSException;
    public StockingBreedDailyCollection getStockingBreedDailyCollection(String oql) throws BOSException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(StockingBreedDailyInfo model) throws BOSException, EASBizException;
    public void unAudit(StockingBreedDailyInfo model) throws BOSException, EASBizException;
    public List genNextBill(StockingBreedDailyInfo model) throws BOSException;
    public void reShareCoalAndDiesel(StockingBreedDailyInfo model) throws BOSException;
    public String recalStockingByBatchID(String String) throws BOSException, EASBizException;
}