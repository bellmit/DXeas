package com.kingdee.eas.farm.breed;

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

public interface IBreedBatch extends ICoreBillBase
{
    public BreedBatchCollection getBreedBatchCollection() throws BOSException;
    public BreedBatchCollection getBreedBatchCollection(EntityViewInfo view) throws BOSException;
    public BreedBatchCollection getBreedBatchCollection(String oql) throws BOSException;
    public BreedBatchInfo getBreedBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedBatchInfo getBreedBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedBatchInfo getBreedBatchInfo(String oql) throws BOSException, EASBizException;
    public void audit(BreedBatchInfo model) throws BOSException;
    public void unAudit(BreedBatchInfo model) throws BOSException;
    public void updateBatchMarket(BreedBatchInfo model) throws BOSException;
}