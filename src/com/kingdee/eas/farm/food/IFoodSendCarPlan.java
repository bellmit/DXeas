package com.kingdee.eas.farm.food;

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

public interface IFoodSendCarPlan extends ICoreBillBase
{
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection() throws BOSException;
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection(EntityViewInfo view) throws BOSException;
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection(String oql) throws BOSException;
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(FoodSendCarPlanInfo model) throws BOSException;
    public void unAudit(FoodSendCarPlanInfo model) throws BOSException;
}