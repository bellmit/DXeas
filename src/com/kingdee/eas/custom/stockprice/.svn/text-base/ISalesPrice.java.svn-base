package com.kingdee.eas.custom.stockprice;

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

public interface ISalesPrice extends ICoreBillBase
{
    public SalesPriceCollection getSalesPriceCollection() throws BOSException;
    public SalesPriceCollection getSalesPriceCollection(EntityViewInfo view) throws BOSException;
    public SalesPriceCollection getSalesPriceCollection(String oql) throws BOSException;
    public SalesPriceInfo getSalesPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalesPriceInfo getSalesPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalesPriceInfo getSalesPriceInfo(String oql) throws BOSException, EASBizException;
}