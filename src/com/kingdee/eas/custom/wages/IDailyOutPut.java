package com.kingdee.eas.custom.wages;

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

public interface IDailyOutPut extends ICoreBillBase
{
    public DailyOutPutCollection getDailyOutPutCollection() throws BOSException;
    public DailyOutPutCollection getDailyOutPutCollection(EntityViewInfo view) throws BOSException;
    public DailyOutPutCollection getDailyOutPutCollection(String oql) throws BOSException;
    public DailyOutPutInfo getDailyOutPutInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DailyOutPutInfo getDailyOutPutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DailyOutPutInfo getDailyOutPutInfo(String oql) throws BOSException, EASBizException;
    public void audit(DailyOutPutInfo model) throws BOSException;
    public void unaudit(DailyOutPutInfo model) throws BOSException;
    public void salaryCount(DailyOutPutInfo model) throws BOSException;
}