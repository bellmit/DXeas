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

public interface IBHatchBabyBill extends ICoreBillBase
{
    public BHatchBabyBillCollection getBHatchBabyBillCollection() throws BOSException;
    public BHatchBabyBillCollection getBHatchBabyBillCollection(EntityViewInfo view) throws BOSException;
    public BHatchBabyBillCollection getBHatchBabyBillCollection(String oql) throws BOSException;
    public BHatchBabyBillInfo getBHatchBabyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BHatchBabyBillInfo getBHatchBabyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BHatchBabyBillInfo getBHatchBabyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BHatchBabyBillInfo model) throws BOSException;
    public void unAudit(BHatchBabyBillInfo model) throws BOSException;
    public void multiAudit(BHatchBabyBillInfo model) throws BOSException;
    public void multiAudits(BHatchBabyBillInfo model) throws BOSException;
}