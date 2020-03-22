package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigDailyEntry extends ICoreBillEntryBase
{
    public CCPigDailyEntryInfo getCCPigDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigDailyEntryInfo getCCPigDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigDailyEntryInfo getCCPigDailyEntryInfo(String oql) throws BOSException, EASBizException;
    public CCPigDailyEntryCollection getCCPigDailyEntryCollection() throws BOSException;
    public CCPigDailyEntryCollection getCCPigDailyEntryCollection(EntityViewInfo view) throws BOSException;
    public CCPigDailyEntryCollection getCCPigDailyEntryCollection(String oql) throws BOSException;
}