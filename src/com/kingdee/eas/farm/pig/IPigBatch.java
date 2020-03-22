package com.kingdee.eas.farm.pig;

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

public interface IPigBatch extends ICoreBillBase
{
    public PigBatchCollection getPigBatchCollection() throws BOSException;
    public PigBatchCollection getPigBatchCollection(EntityViewInfo view) throws BOSException;
    public PigBatchCollection getPigBatchCollection(String oql) throws BOSException;
    public PigBatchInfo getPigBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigBatchInfo getPigBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigBatchInfo getPigBatchInfo(String oql) throws BOSException, EASBizException;
    public void audit(PigBatchInfo model) throws BOSException;
    public void unAudit(PigBatchInfo model) throws BOSException;
    public void updateBatchMarket(PigBatchInfo model) throws BOSException;
}