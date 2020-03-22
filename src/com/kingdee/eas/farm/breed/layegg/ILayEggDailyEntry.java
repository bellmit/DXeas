package com.kingdee.eas.farm.breed.layegg;

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

public interface ILayEggDailyEntry extends ICoreBillEntryBase
{
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(String oql) throws BOSException, EASBizException;
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection() throws BOSException;
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection(EntityViewInfo view) throws BOSException;
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection(String oql) throws BOSException;
}