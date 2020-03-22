package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigBatchEntry extends ICoreBillEntryBase
{
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigBatchEntryInfo getCCPigBatchEntryInfo(String oql) throws BOSException, EASBizException;
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection() throws BOSException;
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection(EntityViewInfo view) throws BOSException;
    public CCPigBatchEntryCollection getCCPigBatchEntryCollection(String oql) throws BOSException;
}