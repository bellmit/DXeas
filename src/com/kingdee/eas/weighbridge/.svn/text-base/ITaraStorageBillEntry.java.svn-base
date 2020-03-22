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

public interface ITaraStorageBillEntry extends ICoreBillEntryBase
{
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(String oql) throws BOSException, EASBizException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection() throws BOSException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(EntityViewInfo view) throws BOSException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(String oql) throws BOSException;
}