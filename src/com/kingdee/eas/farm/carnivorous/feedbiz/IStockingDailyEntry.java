package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IStockingDailyEntry extends ICoreBillEntryBase
{
    public StockingDailyEntryInfo getStockingDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingDailyEntryInfo getStockingDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingDailyEntryInfo getStockingDailyEntryInfo(String oql) throws BOSException, EASBizException;
    public StockingDailyEntryCollection getStockingDailyEntryCollection() throws BOSException;
    public StockingDailyEntryCollection getStockingDailyEntryCollection(EntityViewInfo view) throws BOSException;
    public StockingDailyEntryCollection getStockingDailyEntryCollection(String oql) throws BOSException;
}