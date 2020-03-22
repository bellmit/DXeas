package com.kingdee.eas.farm.breed.brood;

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

public interface IBroodDailyEntry extends ICoreBillEntryBase
{
    public BroodDailyEntryInfo getBroodDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BroodDailyEntryInfo getBroodDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BroodDailyEntryInfo getBroodDailyEntryInfo(String oql) throws BOSException, EASBizException;
    public BroodDailyEntryCollection getBroodDailyEntryCollection() throws BOSException;
    public BroodDailyEntryCollection getBroodDailyEntryCollection(EntityViewInfo view) throws BOSException;
    public BroodDailyEntryCollection getBroodDailyEntryCollection(String oql) throws BOSException;
}