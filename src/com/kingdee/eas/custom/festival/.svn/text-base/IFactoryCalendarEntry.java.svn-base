package com.kingdee.eas.custom.festival;

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

public interface IFactoryCalendarEntry extends ICoreBillEntryBase
{
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(String oql) throws BOSException, EASBizException;
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection() throws BOSException;
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection(EntityViewInfo view) throws BOSException;
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection(String oql) throws BOSException;
}