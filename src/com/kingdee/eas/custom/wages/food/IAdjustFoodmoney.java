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

public interface IAdjustFoodmoney extends ICoreBillBase
{
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection() throws BOSException;
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(EntityViewInfo view) throws BOSException;
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(String oql) throws BOSException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(String oql) throws BOSException, EASBizException;
    public void audit(AdjustFoodmoneyInfo model) throws BOSException;
    public void unaudit(AdjustFoodmoneyInfo model) throws BOSException;
}