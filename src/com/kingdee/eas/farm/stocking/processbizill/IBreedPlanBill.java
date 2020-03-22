package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IBreedPlanBill extends ICoreBillBase
{
    public BreedPlanBillCollection getBreedPlanBillCollection() throws BOSException;
    public BreedPlanBillCollection getBreedPlanBillCollection(EntityViewInfo view) throws BOSException;
    public BreedPlanBillCollection getBreedPlanBillCollection(String oql) throws BOSException;
    public BreedPlanBillInfo getBreedPlanBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedPlanBillInfo getBreedPlanBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedPlanBillInfo getBreedPlanBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BreedPlanBillInfo model) throws BOSException;
    public void unAudit(BreedPlanBillInfo model) throws BOSException;
}