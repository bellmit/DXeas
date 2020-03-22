package com.kingdee.eas.custom.farmpolling;

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

public interface IPollingRecordBillEntry extends ICoreBillEntryBase
{
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(String oql) throws BOSException, EASBizException;
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection() throws BOSException;
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection(EntityViewInfo view) throws BOSException;
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection(String oql) throws BOSException;
}