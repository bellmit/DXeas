package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IEarlyEggStock extends ICoreBillBase
{
    public EarlyEggStockCollection getEarlyEggStockCollection() throws BOSException;
    public EarlyEggStockCollection getEarlyEggStockCollection(EntityViewInfo view) throws BOSException;
    public EarlyEggStockCollection getEarlyEggStockCollection(String oql) throws BOSException;
    public EarlyEggStockInfo getEarlyEggStockInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EarlyEggStockInfo getEarlyEggStockInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EarlyEggStockInfo getEarlyEggStockInfo(String oql) throws BOSException, EASBizException;
    public void audit(IObjectValue Info) throws BOSException, EASBizException;
}