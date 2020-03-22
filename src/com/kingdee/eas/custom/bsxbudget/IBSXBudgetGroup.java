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

public interface IBSXBudgetGroup extends ICoreBillBase
{
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection() throws BOSException;
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(EntityViewInfo view) throws BOSException;
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(String oql) throws BOSException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(String oql) throws BOSException, EASBizException;
    public void audit(BSXBudgetGroupInfo model) throws BOSException, EASBizException;
    public void unAudit(BSXBudgetGroupInfo model) throws BOSException, EASBizException;
}