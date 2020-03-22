package com.kingdee.eas.farm.stocking.basebizbill;

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

public interface IFarmerApplyBill extends ICoreBillBase
{
    public FarmerApplyBillCollection getFarmerApplyBillCollection() throws BOSException;
    public FarmerApplyBillCollection getFarmerApplyBillCollection(EntityViewInfo view) throws BOSException;
    public FarmerApplyBillCollection getFarmerApplyBillCollection(String oql) throws BOSException;
    public FarmerApplyBillInfo getFarmerApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerApplyBillInfo getFarmerApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerApplyBillInfo getFarmerApplyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FarmerApplyBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerApplyBillInfo model) throws BOSException, EASBizException;
    public void isTemplate(FarmerApplyBillInfo model) throws BOSException;
    public void isCheckItemEntry(FarmerApplyBillInfo model) throws BOSException;
}