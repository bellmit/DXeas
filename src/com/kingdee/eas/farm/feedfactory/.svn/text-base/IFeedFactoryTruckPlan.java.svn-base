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

public interface IFeedFactoryTruckPlan extends ICoreBillBase
{
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection() throws BOSException;
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(EntityViewInfo view) throws BOSException;
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(String oql) throws BOSException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(String oql) throws BOSException, EASBizException;
    public void getFodderPlan(FeedFactoryTruckPlanInfo model) throws BOSException;
    public void generateTruckPlan(FeedFactoryTruckPlanInfo model) throws BOSException;
    public void audit(FeedFactoryTruckPlanInfo model) throws BOSException;
    public void unAudit(FeedFactoryTruckPlanInfo model) throws BOSException;
}