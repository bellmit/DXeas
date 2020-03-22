package com.kingdee.eas.custom.salediscount;

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

public interface IDiscountGridLog extends ICoreBillBase
{
    public DiscountGridLogCollection getDiscountGridLogCollection() throws BOSException;
    public DiscountGridLogCollection getDiscountGridLogCollection(EntityViewInfo view) throws BOSException;
    public DiscountGridLogCollection getDiscountGridLogCollection(String oql) throws BOSException;
    public DiscountGridLogInfo getDiscountGridLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountGridLogInfo getDiscountGridLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountGridLogInfo getDiscountGridLogInfo(String oql) throws BOSException, EASBizException;
}