package com.kingdee.eas.farm.dayratecost;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDayRateBaseSetting extends IDataBase
{
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DayRateBaseSettingInfo getDayRateBaseSettingInfo(String oql) throws BOSException, EASBizException;
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection() throws BOSException;
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection(EntityViewInfo view) throws BOSException;
    public DayRateBaseSettingCollection getDayRateBaseSettingCollection(String oql) throws BOSException;
}