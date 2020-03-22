package com.kingdee.eas.custom.foodtrac;

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

public interface ILeavecheckEntry extends ICoreBillEntryBase
{
    public LeavecheckEntryInfo getLeavecheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LeavecheckEntryInfo getLeavecheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LeavecheckEntryInfo getLeavecheckEntryInfo(String oql) throws BOSException, EASBizException;
    public LeavecheckEntryCollection getLeavecheckEntryCollection() throws BOSException;
    public LeavecheckEntryCollection getLeavecheckEntryCollection(EntityViewInfo view) throws BOSException;
    public LeavecheckEntryCollection getLeavecheckEntryCollection(String oql) throws BOSException;
}