package com.kingdee.eas.farm.food;

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

public interface IFreshCountBillEntry extends ICoreBillEntryBase
{
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(String oql) throws BOSException, EASBizException;
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection() throws BOSException;
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection(EntityViewInfo view) throws BOSException;
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection(String oql) throws BOSException;
}