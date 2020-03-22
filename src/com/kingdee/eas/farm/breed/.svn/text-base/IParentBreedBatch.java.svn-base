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

public interface IParentBreedBatch extends ICoreBillBase
{
    public ParentBreedBatchCollection getParentBreedBatchCollection() throws BOSException;
    public ParentBreedBatchCollection getParentBreedBatchCollection(EntityViewInfo view) throws BOSException;
    public ParentBreedBatchCollection getParentBreedBatchCollection(String oql) throws BOSException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(String oql) throws BOSException, EASBizException;
    public void audit(ParentBreedBatchInfo model) throws BOSException;
    public void unAudit(ParentBreedBatchInfo model) throws BOSException;
    public void updateBatchMarket(ParentBreedBatchInfo model) throws BOSException;
}