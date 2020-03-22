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

public interface ICCBreedPlan extends ICoreBillBase
{
    public CCBreedPlanCollection getCCBreedPlanCollection() throws BOSException;
    public CCBreedPlanCollection getCCBreedPlanCollection(EntityViewInfo view) throws BOSException;
    public CCBreedPlanCollection getCCBreedPlanCollection(String oql) throws BOSException;
    public CCBreedPlanInfo getCCBreedPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCBreedPlanInfo getCCBreedPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCBreedPlanInfo getCCBreedPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(CCBreedPlanInfo model) throws BOSException;
    public void unAudit(CCBreedPlanInfo model) throws BOSException;
    public void getCCBreedPlan(CCBreedPlanInfo model) throws BOSException;
}