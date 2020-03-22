package com.kingdee.eas.farm.breed.layegg;

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

public interface ILayEggPlan extends ICoreBillBase
{
    public LayEggPlanCollection getLayEggPlanCollection() throws BOSException;
    public LayEggPlanCollection getLayEggPlanCollection(EntityViewInfo view) throws BOSException;
    public LayEggPlanCollection getLayEggPlanCollection(String oql) throws BOSException;
    public LayEggPlanInfo getLayEggPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LayEggPlanInfo getLayEggPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LayEggPlanInfo getLayEggPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(LayEggPlanInfo model) throws BOSException;
    public void unAudit(LayEggPlanInfo model) throws BOSException;
}