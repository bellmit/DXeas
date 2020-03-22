package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IBreedPlanBillEntry extends ICoreBillEntryBase
{
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(String oql) throws BOSException, EASBizException;
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection() throws BOSException;
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection(EntityViewInfo view) throws BOSException;
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection(String oql) throws BOSException;
}