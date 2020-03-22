package com.kingdee.eas.custom.salepayment;

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

public interface IMonthFeeEntry extends ICoreBillEntryBase
{
    public MonthFeeEntryInfo getMonthFeeEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MonthFeeEntryInfo getMonthFeeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MonthFeeEntryInfo getMonthFeeEntryInfo(String oql) throws BOSException, EASBizException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection() throws BOSException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection(EntityViewInfo view) throws BOSException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection(String oql) throws BOSException;
}