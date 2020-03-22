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

public interface IStockingBatch extends IDataBase
{
    public StockingBatchInfo getStockingBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingBatchInfo getStockingBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingBatchInfo getStockingBatchInfo(String oql) throws BOSException, EASBizException;
    public StockingBatchCollection getStockingBatchCollection() throws BOSException;
    public StockingBatchCollection getStockingBatchCollection(EntityViewInfo view) throws BOSException;
    public StockingBatchCollection getStockingBatchCollection(String oql) throws BOSException;
    public void audit(StockingBatchInfo model) throws BOSException, EASBizException;
    public void unAudit(StockingBatchInfo model) throws BOSException, EASBizException;
    public void recalQty(StockingBatchInfo model) throws BOSException, EASBizException;
}