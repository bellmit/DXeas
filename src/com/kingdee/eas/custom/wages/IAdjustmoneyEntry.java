package com.kingdee.eas.custom.wages;

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

public interface IAdjustmoneyEntry extends ICoreBillEntryBase
{
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(String oql) throws BOSException, EASBizException;
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection() throws BOSException;
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection(EntityViewInfo view) throws BOSException;
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection(String oql) throws BOSException;
}