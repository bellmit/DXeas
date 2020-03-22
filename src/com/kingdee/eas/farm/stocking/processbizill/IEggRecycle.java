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

public interface IEggRecycle extends ICoreBillBase
{
    public EggRecycleCollection getEggRecycleCollection() throws BOSException;
    public EggRecycleCollection getEggRecycleCollection(EntityViewInfo view) throws BOSException;
    public EggRecycleCollection getEggRecycleCollection(String oql) throws BOSException;
    public EggRecycleInfo getEggRecycleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggRecycleInfo getEggRecycleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggRecycleInfo getEggRecycleInfo(String oql) throws BOSException, EASBizException;
    public void audit(EggRecycleInfo model) throws BOSException;
    public void unAudit(EggRecycleInfo model) throws BOSException;
}