package com.kingdee.eas.custom.wages.food;

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

public interface IAchievement extends ICoreBillBase
{
    public AchievementCollection getAchievementCollection() throws BOSException;
    public AchievementCollection getAchievementCollection(EntityViewInfo view) throws BOSException;
    public AchievementCollection getAchievementCollection(String oql) throws BOSException;
    public AchievementInfo getAchievementInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AchievementInfo getAchievementInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AchievementInfo getAchievementInfo(String oql) throws BOSException, EASBizException;
    public void audit(AchievementInfo model) throws BOSException;
    public void unaudit(AchievementInfo model) throws BOSException;
}