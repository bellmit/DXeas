package com.kingdee.eas.farm.dayratecost;

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

public interface ICostAllocation extends ICoreBillBase
{
    public CostAllocationCollection getCostAllocationCollection() throws BOSException;
    public CostAllocationCollection getCostAllocationCollection(EntityViewInfo view) throws BOSException;
    public CostAllocationCollection getCostAllocationCollection(String oql) throws BOSException;
    public CostAllocationInfo getCostAllocationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CostAllocationInfo getCostAllocationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CostAllocationInfo getCostAllocationInfo(String oql) throws BOSException, EASBizException;
    public void audit(CostAllocationInfo model) throws BOSException, EASBizException;
    public void unAudit(CostAllocationInfo model) throws BOSException, EASBizException;
    public void exeAllocation(CostAllocationInfo model) throws BOSException, EASBizException;
}