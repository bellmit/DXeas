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

public interface ITranInEntry extends ICoreBillEntryBase
{
    public TranInEntryInfo getTranInEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TranInEntryInfo getTranInEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TranInEntryInfo getTranInEntryInfo(String oql) throws BOSException, EASBizException;
    public TranInEntryCollection getTranInEntryCollection() throws BOSException;
    public TranInEntryCollection getTranInEntryCollection(EntityViewInfo view) throws BOSException;
    public TranInEntryCollection getTranInEntryCollection(String oql) throws BOSException;
}