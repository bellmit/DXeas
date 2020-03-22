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

public interface IRealTimeInventoryEntry extends ICoreBillEntryBase
{
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(String oql) throws BOSException, EASBizException;
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection() throws BOSException;
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection(EntityViewInfo view) throws BOSException;
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection(String oql) throws BOSException;
}