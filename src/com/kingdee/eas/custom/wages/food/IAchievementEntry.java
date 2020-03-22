package com.kingdee.eas.custom.wages.food;

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

public interface IAchievementEntry extends ICoreBillEntryBase
{
    public AchievementEntryInfo getAchievementEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchievementEntryInfo getAchievementEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchievementEntryInfo getAchievementEntryInfo(String oql) throws BOSException, EASBizException;
    public AchievementEntryCollection getAchievementEntryCollection() throws BOSException;
    public AchievementEntryCollection getAchievementEntryCollection(EntityViewInfo view) throws BOSException;
    public AchievementEntryCollection getAchievementEntryCollection(String oql) throws BOSException;
}