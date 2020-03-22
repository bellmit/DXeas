package com.kingdee.eas.farm.pig.breedingsow;

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

public interface IDeliveryRecordBill extends ICoreBillBase
{
    public DeliveryRecordBillCollection getDeliveryRecordBillCollection() throws BOSException;
    public DeliveryRecordBillCollection getDeliveryRecordBillCollection(EntityViewInfo view) throws BOSException;
    public DeliveryRecordBillCollection getDeliveryRecordBillCollection(String oql) throws BOSException;
    public DeliveryRecordBillInfo getDeliveryRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeliveryRecordBillInfo getDeliveryRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeliveryRecordBillInfo getDeliveryRecordBillInfo(String oql) throws BOSException, EASBizException;
}