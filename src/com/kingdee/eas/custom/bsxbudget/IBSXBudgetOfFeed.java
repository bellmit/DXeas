package com.kingdee.eas.custom.bsxbudget;

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

public interface IBSXBudgetOfFeed extends ICoreBillBase
{
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection() throws BOSException;
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection(EntityViewInfo view) throws BOSException;
    public BSXBudgetOfFeedCollection getBSXBudgetOfFeedCollection(String oql) throws BOSException;
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BSXBudgetOfFeedInfo getBSXBudgetOfFeedInfo(String oql) throws BOSException, EASBizException;
    public void getLairageQty(BSXBudgetOfFeedInfo model) throws BOSException;
    public void audit(BSXBudgetOfFeedInfo model) throws BOSException, EASBizException;
    public void unAudit(BSXBudgetOfFeedInfo model) throws BOSException, EASBizException;
}