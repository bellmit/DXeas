package com.kingdee.eas.custom.stockprice;

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

public interface ISalesPriceEntry extends ICoreBillEntryBase
{
    public SalesPriceEntryInfo getSalesPriceEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalesPriceEntryInfo getSalesPriceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalesPriceEntryInfo getSalesPriceEntryInfo(String oql) throws BOSException, EASBizException;
    public SalesPriceEntryCollection getSalesPriceEntryCollection() throws BOSException;
    public SalesPriceEntryCollection getSalesPriceEntryCollection(EntityViewInfo view) throws BOSException;
    public SalesPriceEntryCollection getSalesPriceEntryCollection(String oql) throws BOSException;
}