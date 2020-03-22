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

public interface IHatchAdjustBill extends ICoreBillBase
{
    public HatchAdjustBillCollection getHatchAdjustBillCollection() throws BOSException;
    public HatchAdjustBillCollection getHatchAdjustBillCollection(EntityViewInfo view) throws BOSException;
    public HatchAdjustBillCollection getHatchAdjustBillCollection(String oql) throws BOSException;
    public HatchAdjustBillInfo getHatchAdjustBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchAdjustBillInfo getHatchAdjustBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchAdjustBillInfo getHatchAdjustBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchAdjustBillInfo model) throws BOSException, EASBizException;
    public void unAudit(HatchAdjustBillInfo model) throws BOSException, EASBizException;
}