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

public interface IBreedSeedBillEntry extends ICoreBillEntryBase
{
    public BreedSeedBillEntryInfo getBreedSeedBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedSeedBillEntryInfo getBreedSeedBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedSeedBillEntryInfo getBreedSeedBillEntryInfo(String oql) throws BOSException, EASBizException;
    public BreedSeedBillEntryCollection getBreedSeedBillEntryCollection() throws BOSException;
    public BreedSeedBillEntryCollection getBreedSeedBillEntryCollection(EntityViewInfo view) throws BOSException;
    public BreedSeedBillEntryCollection getBreedSeedBillEntryCollection(String oql) throws BOSException;
}