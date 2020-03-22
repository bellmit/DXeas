package com.kingdee.eas.farm.food.stocount;

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

public interface ISemiProductCountEntry extends ICoreBillEntryBase
{
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(String oql) throws BOSException, EASBizException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection() throws BOSException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(EntityViewInfo view) throws BOSException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(String oql) throws BOSException;
}