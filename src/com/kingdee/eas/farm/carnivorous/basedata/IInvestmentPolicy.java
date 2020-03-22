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

public interface IInvestmentPolicy extends IDataBase
{
    public InvestmentPolicyInfo getInvestmentPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InvestmentPolicyInfo getInvestmentPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InvestmentPolicyInfo getInvestmentPolicyInfo(String oql) throws BOSException, EASBizException;
    public InvestmentPolicyCollection getInvestmentPolicyCollection() throws BOSException;
    public InvestmentPolicyCollection getInvestmentPolicyCollection(EntityViewInfo view) throws BOSException;
    public InvestmentPolicyCollection getInvestmentPolicyCollection(String oql) throws BOSException;
    public void audit(InvestmentPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(InvestmentPolicyInfo model) throws BOSException, EASBizException;
}