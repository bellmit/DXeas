package com.kingdee.eas.farm.stocking.basebizbill;

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

public interface IFarmerApplyBillEntry extends ICoreBillEntryBase
{
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(String oql) throws BOSException, EASBizException;
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection() throws BOSException;
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection(EntityViewInfo view) throws BOSException;
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection(String oql) throws BOSException;
}