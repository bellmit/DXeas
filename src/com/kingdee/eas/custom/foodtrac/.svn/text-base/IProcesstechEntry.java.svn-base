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

public interface IProcesstechEntry extends ICoreBillEntryBase
{
    public ProcesstechEntryInfo getProcesstechEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProcesstechEntryInfo getProcesstechEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProcesstechEntryInfo getProcesstechEntryInfo(String oql) throws BOSException, EASBizException;
    public ProcesstechEntryCollection getProcesstechEntryCollection() throws BOSException;
    public ProcesstechEntryCollection getProcesstechEntryCollection(EntityViewInfo view) throws BOSException;
    public ProcesstechEntryCollection getProcesstechEntryCollection(String oql) throws BOSException;
}