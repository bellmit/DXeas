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

public interface IMarketPolicy extends IDataBase
{
    public MarketPolicyInfo getMarketPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarketPolicyInfo getMarketPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarketPolicyInfo getMarketPolicyInfo(String oql) throws BOSException, EASBizException;
    public MarketPolicyCollection getMarketPolicyCollection() throws BOSException;
    public MarketPolicyCollection getMarketPolicyCollection(EntityViewInfo view) throws BOSException;
    public MarketPolicyCollection getMarketPolicyCollection(String oql) throws BOSException;
    public void audit(MarketPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(MarketPolicyInfo model) throws BOSException, EASBizException;
}