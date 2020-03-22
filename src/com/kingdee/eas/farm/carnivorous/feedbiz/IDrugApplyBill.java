package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IDrugApplyBill extends ICoreBillBase
{
    public DrugApplyBillCollection getDrugApplyBillCollection() throws BOSException;
    public DrugApplyBillCollection getDrugApplyBillCollection(EntityViewInfo view) throws BOSException;
    public DrugApplyBillCollection getDrugApplyBillCollection(String oql) throws BOSException;
    public DrugApplyBillInfo getDrugApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DrugApplyBillInfo getDrugApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DrugApplyBillInfo getDrugApplyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(DrugApplyBillInfo model) throws BOSException, EASBizException;
    public void unAudit(DrugApplyBillInfo model) throws BOSException, EASBizException;
    public void close(DrugApplyBillInfo model) throws BOSException, EASBizException;
    public void unClose(DrugApplyBillInfo model) throws BOSException, EASBizException;
}