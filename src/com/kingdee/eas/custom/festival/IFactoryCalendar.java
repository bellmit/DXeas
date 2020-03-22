package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFactoryCalendar extends ICoreBillBase
{
    public FactoryCalendarCollection getFactoryCalendarCollection() throws BOSException;
    public FactoryCalendarCollection getFactoryCalendarCollection(EntityViewInfo view) throws BOSException;
    public FactoryCalendarCollection getFactoryCalendarCollection(String oql) throws BOSException;
    public FactoryCalendarInfo getFactoryCalendarInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FactoryCalendarInfo getFactoryCalendarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FactoryCalendarInfo getFactoryCalendarInfo(String oql) throws BOSException, EASBizException;
}