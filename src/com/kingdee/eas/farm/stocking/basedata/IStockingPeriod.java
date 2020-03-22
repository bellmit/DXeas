package com.kingdee.eas.farm.stocking.basedata;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IStockingPeriod extends IDataBase
{
    public StockingPeriodInfo getStockingPeriodInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingPeriodInfo getStockingPeriodInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingPeriodInfo getStockingPeriodInfo(String oql) throws BOSException, EASBizException;
    public StockingPeriodCollection getStockingPeriodCollection() throws BOSException;
    public StockingPeriodCollection getStockingPeriodCollection(EntityViewInfo view) throws BOSException;
    public StockingPeriodCollection getStockingPeriodCollection(String oql) throws BOSException;
}