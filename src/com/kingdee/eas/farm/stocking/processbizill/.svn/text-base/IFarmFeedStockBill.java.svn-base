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

public interface IFarmFeedStockBill extends ICoreBillBase
{
    public FarmFeedStockBillCollection getFarmFeedStockBillCollection() throws BOSException;
    public FarmFeedStockBillCollection getFarmFeedStockBillCollection(EntityViewInfo view) throws BOSException;
    public FarmFeedStockBillCollection getFarmFeedStockBillCollection(String oql) throws BOSException;
    public FarmFeedStockBillInfo getFarmFeedStockBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmFeedStockBillInfo getFarmFeedStockBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmFeedStockBillInfo getFarmFeedStockBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FarmFeedStockBillInfo model) throws BOSException;
    public void unAudit(FarmFeedStockBillInfo model) throws BOSException;
}