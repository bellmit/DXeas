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

public interface IBEggHatchBill extends ICoreBillBase
{
    public BEggHatchBillCollection getBEggHatchBillCollection() throws BOSException;
    public BEggHatchBillCollection getBEggHatchBillCollection(EntityViewInfo view) throws BOSException;
    public BEggHatchBillCollection getBEggHatchBillCollection(String oql) throws BOSException;
    public BEggHatchBillInfo getBEggHatchBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BEggHatchBillInfo getBEggHatchBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BEggHatchBillInfo getBEggHatchBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BEggHatchBillInfo model) throws BOSException, EASBizException;
    public void unAudit(BEggHatchBillInfo model) throws BOSException, EASBizException;
    public void adjust(BEggHatchBillInfo model) throws BOSException;
}