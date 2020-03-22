package com.kingdee.eas.farm.stocking.hatch;

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

public interface IInventory extends ICoreBillBase
{
    public InventoryCollection getInventoryCollection() throws BOSException;
    public InventoryCollection getInventoryCollection(EntityViewInfo view) throws BOSException;
    public InventoryCollection getInventoryCollection(String oql) throws BOSException;
    public InventoryInfo getInventoryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InventoryInfo getInventoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InventoryInfo getInventoryInfo(String oql) throws BOSException, EASBizException;
}