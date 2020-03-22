package com.kingdee.eas.custom.purchasebudget;

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

public interface IPurBudgetEntry extends ICoreBillEntryBase
{
    public PurBudgetEntryInfo getPurBudgetEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PurBudgetEntryInfo getPurBudgetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PurBudgetEntryInfo getPurBudgetEntryInfo(String oql) throws BOSException, EASBizException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection() throws BOSException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection(EntityViewInfo view) throws BOSException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection(String oql) throws BOSException;
}