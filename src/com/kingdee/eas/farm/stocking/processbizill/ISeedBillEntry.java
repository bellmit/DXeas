package com.kingdee.eas.farm.stocking.processbizill;

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

public interface ISeedBillEntry extends ICoreBillEntryBase
{
    public SeedBillEntryInfo getSeedBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SeedBillEntryInfo getSeedBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SeedBillEntryInfo getSeedBillEntryInfo(String oql) throws BOSException, EASBizException;
    public SeedBillEntryCollection getSeedBillEntryCollection() throws BOSException;
    public SeedBillEntryCollection getSeedBillEntryCollection(EntityViewInfo view) throws BOSException;
    public SeedBillEntryCollection getSeedBillEntryCollection(String oql) throws BOSException;
}