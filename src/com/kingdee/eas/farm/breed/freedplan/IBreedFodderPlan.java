package com.kingdee.eas.farm.breed.freedplan;

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

public interface IBreedFodderPlan extends ICoreBillBase
{
    public BreedFodderPlanCollection getBreedFodderPlanCollection() throws BOSException;
    public BreedFodderPlanCollection getBreedFodderPlanCollection(EntityViewInfo view) throws BOSException;
    public BreedFodderPlanCollection getBreedFodderPlanCollection(String oql) throws BOSException;
    public BreedFodderPlanInfo getBreedFodderPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedFodderPlanInfo getBreedFodderPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedFodderPlanInfo getBreedFodderPlanInfo(String oql) throws BOSException, EASBizException;
}