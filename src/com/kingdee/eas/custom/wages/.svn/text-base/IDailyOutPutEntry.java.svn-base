package com.kingdee.eas.custom.wages;

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

public interface IDailyOutPutEntry extends ICoreBillEntryBase
{
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DailyOutPutEntryInfo getDailyOutPutEntryInfo(String oql) throws BOSException, EASBizException;
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection() throws BOSException;
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection(EntityViewInfo view) throws BOSException;
    public DailyOutPutEntryCollection getDailyOutPutEntryCollection(String oql) throws BOSException;
}