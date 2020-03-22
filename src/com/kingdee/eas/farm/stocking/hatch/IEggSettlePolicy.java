package com.kingdee.eas.farm.stocking.hatch;

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

public interface IEggSettlePolicy extends IDataBase
{
    public EggSettlePolicyInfo getEggSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggSettlePolicyInfo getEggSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggSettlePolicyInfo getEggSettlePolicyInfo(String oql) throws BOSException, EASBizException;
    public EggSettlePolicyCollection getEggSettlePolicyCollection() throws BOSException;
    public EggSettlePolicyCollection getEggSettlePolicyCollection(EntityViewInfo view) throws BOSException;
    public EggSettlePolicyCollection getEggSettlePolicyCollection(String oql) throws BOSException;
    public void audit(EggSettlePolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(EggSettlePolicyInfo model) throws BOSException, EASBizException;
}