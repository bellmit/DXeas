package com.kingdee.eas.farm.dayratecost;

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

public interface IArAmountOffsetDetailBill extends ICoreBillBase
{
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection() throws BOSException;
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(EntityViewInfo view) throws BOSException;
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(String oql) throws BOSException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException;
    public void unAudit(ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException;
}