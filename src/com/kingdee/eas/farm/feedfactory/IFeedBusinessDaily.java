package com.kingdee.eas.farm.feedfactory;

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

public interface IFeedBusinessDaily extends ICoreBillBase
{
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection() throws BOSException;
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(EntityViewInfo view) throws BOSException;
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(String oql) throws BOSException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(FeedBusinessDailyInfo model) throws BOSException;
    public void unAudit(FeedBusinessDailyInfo model) throws BOSException;
}