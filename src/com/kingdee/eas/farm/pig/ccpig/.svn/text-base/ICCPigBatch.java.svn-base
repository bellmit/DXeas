package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigBatch extends ICoreBillBase
{
    public CCPigBatchCollection getCCPigBatchCollection() throws BOSException;
    public CCPigBatchCollection getCCPigBatchCollection(EntityViewInfo view) throws BOSException;
    public CCPigBatchCollection getCCPigBatchCollection(String oql) throws BOSException;
    public CCPigBatchInfo getCCPigBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigBatchInfo getCCPigBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigBatchInfo getCCPigBatchInfo(String oql) throws BOSException, EASBizException;
    public void audit(CCPigBatchInfo model) throws BOSException;
    public void unAudit(CCPigBatchInfo model) throws BOSException;
    public void updateBatchMarket(CCPigBatchInfo model) throws BOSException;
}