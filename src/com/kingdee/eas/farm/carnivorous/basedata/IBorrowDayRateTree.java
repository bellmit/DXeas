package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IBorrowDayRateTree extends ITreeBase
{
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(String oql) throws BOSException, EASBizException;
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection() throws BOSException;
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection(EntityViewInfo view) throws BOSException;
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection(String oql) throws BOSException;
}