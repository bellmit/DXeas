package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface ICKWeightBillEntry extends ICoreBillEntryBase
{
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection() throws BOSException;
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection(String oql) throws BOSException;
}