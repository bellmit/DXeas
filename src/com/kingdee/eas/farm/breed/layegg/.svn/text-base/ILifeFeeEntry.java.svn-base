package com.kingdee.eas.farm.breed.layegg;

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

public interface ILifeFeeEntry extends ICoreBillEntryBase
{
    public LifeFeeEntryInfo getLifeFeeEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LifeFeeEntryInfo getLifeFeeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LifeFeeEntryInfo getLifeFeeEntryInfo(String oql) throws BOSException, EASBizException;
    public LifeFeeEntryCollection getLifeFeeEntryCollection() throws BOSException;
    public LifeFeeEntryCollection getLifeFeeEntryCollection(EntityViewInfo view) throws BOSException;
    public LifeFeeEntryCollection getLifeFeeEntryCollection(String oql) throws BOSException;
}