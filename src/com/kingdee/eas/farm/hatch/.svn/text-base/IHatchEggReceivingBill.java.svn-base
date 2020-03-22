package com.kingdee.eas.farm.hatch;

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

public interface IHatchEggReceivingBill extends ICoreBillBase
{
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection() throws BOSException;
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(EntityViewInfo view) throws BOSException;
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(String oql) throws BOSException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchEggReceivingBillInfo model) throws BOSException;
    public void unAudit(HatchEggReceivingBillInfo model) throws BOSException;
}