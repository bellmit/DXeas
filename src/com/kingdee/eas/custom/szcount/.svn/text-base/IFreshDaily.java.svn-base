package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFreshDaily extends IWlhlBillBase
{
    public FreshDailyCollection getFreshDailyCollection() throws BOSException;
    public FreshDailyCollection getFreshDailyCollection(EntityViewInfo view) throws BOSException;
    public FreshDailyCollection getFreshDailyCollection(String oql) throws BOSException;
    public FreshDailyInfo getFreshDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreshDailyInfo getFreshDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreshDailyInfo getFreshDailyInfo(String oql) throws BOSException, EASBizException;
    public void getData(FreshDailyInfo model) throws BOSException;
}