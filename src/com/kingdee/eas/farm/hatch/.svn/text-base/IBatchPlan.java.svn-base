package com.kingdee.eas.farm.hatch;

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

public interface IBatchPlan extends ICoreBillBase
{
    public BatchPlanCollection getBatchPlanCollection() throws BOSException;
    public BatchPlanCollection getBatchPlanCollection(EntityViewInfo view) throws BOSException;
    public BatchPlanCollection getBatchPlanCollection(String oql) throws BOSException;
    public BatchPlanInfo getBatchPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchPlanInfo getBatchPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchPlanInfo getBatchPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(BatchPlanInfo model) throws BOSException;
    public void unAudit(BatchPlanInfo model) throws BOSException;
    public void getLayEggPlan(BatchPlanInfo model) throws BOSException;
}