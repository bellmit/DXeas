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

public interface IDrugReceptionBill extends ICoreBillBase
{
    public DrugReceptionBillCollection getDrugReceptionBillCollection() throws BOSException;
    public DrugReceptionBillCollection getDrugReceptionBillCollection(EntityViewInfo view) throws BOSException;
    public DrugReceptionBillCollection getDrugReceptionBillCollection(String oql) throws BOSException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(DrugReceptionBillInfo model) throws BOSException, EASBizException;
    public void unAudit(DrugReceptionBillInfo model) throws BOSException, EASBizException;
    public void chkVoucherFlag(DrugReceptionBillInfo model) throws BOSException;
    public void chkVoucherAll(DrugReceptionBillInfo model) throws BOSException;
}