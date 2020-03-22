package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IStockingBatchChangeBill extends ICoreBillBase
{
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection() throws BOSException;
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection(EntityViewInfo view) throws BOSException;
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection(String oql) throws BOSException;
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(StockingBatchChangeBillInfo model) throws BOSException;
    public void unAudit(StockingBatchChangeBillInfo model) throws BOSException;
}