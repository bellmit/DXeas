package com.kingdee.eas.farm.stocking.basedata;

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

public interface ISellSeedlingSettlePolicy extends IDataBase
{
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(String oql) throws BOSException, EASBizException;
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection() throws BOSException;
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection(EntityViewInfo view) throws BOSException;
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection(String oql) throws BOSException;
    public void audit(SellSeedlingSettlePolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(SellSeedlingSettlePolicyInfo model) throws BOSException, EASBizException;
}