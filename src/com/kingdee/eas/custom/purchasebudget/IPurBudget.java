package com.kingdee.eas.custom.purchasebudget;

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

public interface IPurBudget extends ICoreBillBase
{
    public PurBudgetCollection getPurBudgetCollection() throws BOSException;
    public PurBudgetCollection getPurBudgetCollection(EntityViewInfo view) throws BOSException;
    public PurBudgetCollection getPurBudgetCollection(String oql) throws BOSException;
    public PurBudgetInfo getPurBudgetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PurBudgetInfo getPurBudgetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PurBudgetInfo getPurBudgetInfo(String oql) throws BOSException, EASBizException;
    public void audit(PurBudgetInfo model) throws BOSException, EASBizException;
    public void unAudit(PurBudgetInfo model) throws BOSException, EASBizException;
    public void noPass(PurBudgetInfo model) throws BOSException, EASBizException;
    public void importFormExcel(PurBudgetInfo model) throws BOSException;
}