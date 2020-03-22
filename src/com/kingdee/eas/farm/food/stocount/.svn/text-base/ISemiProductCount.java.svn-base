package com.kingdee.eas.farm.food.stocount;

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

public interface ISemiProductCount extends ICoreBillBase
{
    public SemiProductCountCollection getSemiProductCountCollection() throws BOSException;
    public SemiProductCountCollection getSemiProductCountCollection(EntityViewInfo view) throws BOSException;
    public SemiProductCountCollection getSemiProductCountCollection(String oql) throws BOSException;
    public SemiProductCountInfo getSemiProductCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SemiProductCountInfo getSemiProductCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SemiProductCountInfo getSemiProductCountInfo(String oql) throws BOSException, EASBizException;
}