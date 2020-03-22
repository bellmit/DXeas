package com.kingdee.eas.farm.pig;

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

public interface IPigBatchEntry extends ICoreBillEntryBase
{
    public PigBatchEntryInfo getPigBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigBatchEntryInfo getPigBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigBatchEntryInfo getPigBatchEntryInfo(String oql) throws BOSException, EASBizException;
    public PigBatchEntryCollection getPigBatchEntryCollection() throws BOSException;
    public PigBatchEntryCollection getPigBatchEntryCollection(EntityViewInfo view) throws BOSException;
    public PigBatchEntryCollection getPigBatchEntryCollection(String oql) throws BOSException;
}