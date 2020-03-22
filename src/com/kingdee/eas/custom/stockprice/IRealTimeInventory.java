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

public interface IRealTimeInventory extends ICoreBillBase
{
    public RealTimeInventoryCollection getRealTimeInventoryCollection() throws BOSException;
    public RealTimeInventoryCollection getRealTimeInventoryCollection(EntityViewInfo view) throws BOSException;
    public RealTimeInventoryCollection getRealTimeInventoryCollection(String oql) throws BOSException;
    public RealTimeInventoryInfo getRealTimeInventoryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RealTimeInventoryInfo getRealTimeInventoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RealTimeInventoryInfo getRealTimeInventoryInfo(String oql) throws BOSException, EASBizException;
}