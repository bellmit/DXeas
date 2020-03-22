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

public interface IInvestmentPolicyChicken extends IDataBase
{
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InvestmentPolicyChickenInfo getInvestmentPolicyChickenInfo(String oql) throws BOSException, EASBizException;
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection() throws BOSException;
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection(EntityViewInfo view) throws BOSException;
    public InvestmentPolicyChickenCollection getInvestmentPolicyChickenCollection(String oql) throws BOSException;
    public void audit(InvestmentPolicyChickenInfo model) throws BOSException, EASBizException;
    public void unAudit(InvestmentPolicyChickenInfo model) throws BOSException, EASBizException;
}