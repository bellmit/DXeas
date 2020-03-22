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

public interface IHatchBill extends ICoreBillBase
{
    public HatchBillCollection getHatchBillCollection() throws BOSException;
    public HatchBillCollection getHatchBillCollection(EntityViewInfo view) throws BOSException;
    public HatchBillCollection getHatchBillCollection(String oql) throws BOSException;
    public HatchBillInfo getHatchBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBillInfo getHatchBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBillInfo getHatchBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchBillInfo model) throws BOSException;
    public void unAudit(HatchBillInfo model) throws BOSException;
}