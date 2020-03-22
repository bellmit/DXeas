package com.kingdee.eas.farm.stocking.processbizill;

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

public interface ISeedBill extends ICoreBillBase
{
    public SeedBillCollection getSeedBillCollection() throws BOSException;
    public SeedBillCollection getSeedBillCollection(EntityViewInfo view) throws BOSException;
    public SeedBillCollection getSeedBillCollection(String oql) throws BOSException;
    public SeedBillInfo getSeedBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SeedBillInfo getSeedBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SeedBillInfo getSeedBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(SeedBillInfo model) throws BOSException, EASBizException;
    public void unAudit(SeedBillInfo model) throws BOSException, EASBizException;
    public void chkVoucherAll(SeedBillInfo model) throws BOSException;
    public void chkVoucherFlag(SeedBillInfo model) throws BOSException;
}