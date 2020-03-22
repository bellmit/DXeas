package com.kingdee.eas.farm.dayratecost;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDayrateFeeItem extends IDataBase
{
    public DayrateFeeItemInfo getDayrateFeeItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DayrateFeeItemInfo getDayrateFeeItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DayrateFeeItemInfo getDayrateFeeItemInfo(String oql) throws BOSException, EASBizException;
    public DayrateFeeItemCollection getDayrateFeeItemCollection() throws BOSException;
    public DayrateFeeItemCollection getDayrateFeeItemCollection(EntityViewInfo view) throws BOSException;
    public DayrateFeeItemCollection getDayrateFeeItemCollection(String oql) throws BOSException;
    public void audit(DayrateFeeItemInfo model) throws BOSException, EASBizException;
    public void unAudit(DayrateFeeItemInfo model) throws BOSException, EASBizException;
}