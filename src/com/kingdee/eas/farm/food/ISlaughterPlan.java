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

public interface ISlaughterPlan extends ICoreBillBase
{
    public SlaughterPlanCollection getSlaughterPlanCollection() throws BOSException;
    public SlaughterPlanCollection getSlaughterPlanCollection(EntityViewInfo view) throws BOSException;
    public SlaughterPlanCollection getSlaughterPlanCollection(String oql) throws BOSException;
    public SlaughterPlanInfo getSlaughterPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SlaughterPlanInfo getSlaughterPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SlaughterPlanInfo getSlaughterPlanInfo(String oql) throws BOSException, EASBizException;
    public void getSlaughterPlan(SlaughterPlanInfo model) throws BOSException;
    public void audit(SlaughterPlanInfo model) throws BOSException;
    public void unAudit(SlaughterPlanInfo model) throws BOSException;
    public void refresh(SlaughterPlanInfo model) throws BOSException;
}