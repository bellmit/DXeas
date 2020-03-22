package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IPigBatchTypeTree extends ITreeBase
{
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(String oql) throws BOSException, EASBizException;
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection() throws BOSException;
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection(EntityViewInfo view) throws BOSException;
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection(String oql) throws BOSException;
}