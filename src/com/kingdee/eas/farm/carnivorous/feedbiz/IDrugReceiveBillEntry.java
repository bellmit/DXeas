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

public interface IDrugReceiveBillEntry extends ICoreBillEntryBase
{
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(String oql) throws BOSException, EASBizException;
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection() throws BOSException;
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection(EntityViewInfo view) throws BOSException;
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection(String oql) throws BOSException;
}