package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IDrugApplyBillEntry extends ICoreBillEntryBase
{
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(String oql) throws BOSException, EASBizException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection() throws BOSException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(EntityViewInfo view) throws BOSException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(String oql) throws BOSException;
}