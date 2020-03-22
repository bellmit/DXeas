package com.kingdee.eas.weighbridge;

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

public interface IOutStorageBillEntry extends ICoreBillEntryBase
{
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(String oql) throws BOSException, EASBizException;
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection() throws BOSException;
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection(EntityViewInfo view) throws BOSException;
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection(String oql) throws BOSException;
}