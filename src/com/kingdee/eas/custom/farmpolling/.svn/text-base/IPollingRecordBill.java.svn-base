package com.kingdee.eas.custom.farmpolling;

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

public interface IPollingRecordBill extends ICoreBillBase
{
    public PollingRecordBillCollection getPollingRecordBillCollection() throws BOSException;
    public PollingRecordBillCollection getPollingRecordBillCollection(EntityViewInfo view) throws BOSException;
    public PollingRecordBillCollection getPollingRecordBillCollection(String oql) throws BOSException;
    public PollingRecordBillInfo getPollingRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PollingRecordBillInfo getPollingRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PollingRecordBillInfo getPollingRecordBillInfo(String oql) throws BOSException, EASBizException;
}