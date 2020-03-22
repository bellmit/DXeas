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

public interface IBSXBudgetFood extends ICoreBillBase
{
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection() throws BOSException;
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection(EntityViewInfo view) throws BOSException;
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection(String oql) throws BOSException;
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(String oql) throws BOSException, EASBizException;
    public void audit(BSXBudgetFoodInfo model) throws BOSException, EASBizException;
    public void unAudit(BSXBudgetFoodInfo model) throws BOSException, EASBizException;
}