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

public interface IDiscountRecordBillEntry extends ICoreBillEntryBase
{
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(String oql) throws BOSException, EASBizException;
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection() throws BOSException;
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection(EntityViewInfo view) throws BOSException;
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection(String oql) throws BOSException;
}