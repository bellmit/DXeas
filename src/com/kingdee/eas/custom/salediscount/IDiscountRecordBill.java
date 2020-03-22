package com.kingdee.eas.custom.salediscount;

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

public interface IDiscountRecordBill extends ICoreBillBase
{
    public DiscountRecordBillCollection getDiscountRecordBillCollection() throws BOSException;
    public DiscountRecordBillCollection getDiscountRecordBillCollection(EntityViewInfo view) throws BOSException;
    public DiscountRecordBillCollection getDiscountRecordBillCollection(String oql) throws BOSException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(DiscountRecordBillInfo model) throws BOSException;
    public void unAudit(DiscountRecordBillInfo model) throws BOSException;
}