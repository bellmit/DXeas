package com.kingdee.eas.farm.stocking.hatch;

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

public interface IEggSettleBillEntry extends ICoreBillEntryBase
{
    public EggSettleBillEntryInfo getEggSettleBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggSettleBillEntryInfo getEggSettleBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggSettleBillEntryInfo getEggSettleBillEntryInfo(String oql) throws BOSException, EASBizException;
    public EggSettleBillEntryCollection getEggSettleBillEntryCollection() throws BOSException;
    public EggSettleBillEntryCollection getEggSettleBillEntryCollection(EntityViewInfo view) throws BOSException;
    public EggSettleBillEntryCollection getEggSettleBillEntryCollection(String oql) throws BOSException;
}