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

public interface ITranOutEntry extends ICoreBillEntryBase
{
    public TranOutEntryInfo getTranOutEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TranOutEntryInfo getTranOutEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TranOutEntryInfo getTranOutEntryInfo(String oql) throws BOSException, EASBizException;
    public TranOutEntryCollection getTranOutEntryCollection() throws BOSException;
    public TranOutEntryCollection getTranOutEntryCollection(EntityViewInfo view) throws BOSException;
    public TranOutEntryCollection getTranOutEntryCollection(String oql) throws BOSException;
}