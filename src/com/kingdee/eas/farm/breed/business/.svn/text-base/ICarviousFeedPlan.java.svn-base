package com.kingdee.eas.farm.breed.business;

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

public interface ICarviousFeedPlan extends ICoreBillBase
{
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection() throws BOSException;
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection(EntityViewInfo view) throws BOSException;
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection(String oql) throws BOSException;
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(CarviousFeedPlanInfo model) throws BOSException, EASBizException;
    public void unAudit(CarviousFeedPlanInfo model) throws BOSException, EASBizException;
}