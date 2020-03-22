package com.kingdee.eas.custom.salediscount;

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

public interface IDiscountGridLogEntry extends ICoreBillEntryBase
{
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(String oql) throws BOSException, EASBizException;
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection() throws BOSException;
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection(EntityViewInfo view) throws BOSException;
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection(String oql) throws BOSException;
}