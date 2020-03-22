package com.kingdee.eas.farm.hatch;

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

public interface IBatchPlanEntry extends ICoreBillEntryBase
{
    public BatchPlanEntryInfo getBatchPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchPlanEntryInfo getBatchPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchPlanEntryInfo getBatchPlanEntryInfo(String oql) throws BOSException, EASBizException;
    public BatchPlanEntryCollection getBatchPlanEntryCollection() throws BOSException;
    public BatchPlanEntryCollection getBatchPlanEntryCollection(EntityViewInfo view) throws BOSException;
    public BatchPlanEntryCollection getBatchPlanEntryCollection(String oql) throws BOSException;
}