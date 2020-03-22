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

public interface ICTransDrugBillEntry extends ICoreBillEntryBase
{
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection() throws BOSException;
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection(String oql) throws BOSException;
}