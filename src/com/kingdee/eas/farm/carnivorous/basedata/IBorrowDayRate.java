package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IBorrowDayRate extends IDataBase
{
    public BorrowDayRateInfo getBorrowDayRateInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BorrowDayRateInfo getBorrowDayRateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BorrowDayRateInfo getBorrowDayRateInfo(String oql) throws BOSException, EASBizException;
    public BorrowDayRateCollection getBorrowDayRateCollection() throws BOSException;
    public BorrowDayRateCollection getBorrowDayRateCollection(EntityViewInfo view) throws BOSException;
    public BorrowDayRateCollection getBorrowDayRateCollection(String oql) throws BOSException;
    public void audit(BorrowDayRateInfo model) throws BOSException, EASBizException;
    public void unAudit(BorrowDayRateInfo model) throws BOSException, EASBizException;
}