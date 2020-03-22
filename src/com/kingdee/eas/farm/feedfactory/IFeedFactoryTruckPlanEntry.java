package com.kingdee.eas.farm.feedfactory;

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

public interface IFeedFactoryTruckPlanEntry extends ICoreBillEntryBase
{
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(String oql) throws BOSException, EASBizException;
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection() throws BOSException;
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection(EntityViewInfo view) throws BOSException;
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection(String oql) throws BOSException;
}