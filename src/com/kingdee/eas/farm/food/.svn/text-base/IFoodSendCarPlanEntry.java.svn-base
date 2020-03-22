package com.kingdee.eas.farm.food;

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

public interface IFoodSendCarPlanEntry extends ICoreBillEntryBase
{
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(String oql) throws BOSException, EASBizException;
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection() throws BOSException;
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection(EntityViewInfo view) throws BOSException;
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection(String oql) throws BOSException;
}