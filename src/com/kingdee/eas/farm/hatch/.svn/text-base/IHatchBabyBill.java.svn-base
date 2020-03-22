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

public interface IHatchBabyBill extends ICoreBillBase
{
    public HatchBabyBillCollection getHatchBabyBillCollection() throws BOSException;
    public HatchBabyBillCollection getHatchBabyBillCollection(EntityViewInfo view) throws BOSException;
    public HatchBabyBillCollection getHatchBabyBillCollection(String oql) throws BOSException;
    public HatchBabyBillInfo getHatchBabyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBabyBillInfo getHatchBabyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBabyBillInfo getHatchBabyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchBabyBillInfo model) throws BOSException;
    public void unAudit(HatchBabyBillInfo model) throws BOSException;
}