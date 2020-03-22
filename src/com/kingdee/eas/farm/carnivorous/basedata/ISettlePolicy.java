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

public interface ISettlePolicy extends IDataBase
{
    public SettlePolicyInfo getSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettlePolicyInfo getSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettlePolicyInfo getSettlePolicyInfo(String oql) throws BOSException, EASBizException;
    public SettlePolicyCollection getSettlePolicyCollection() throws BOSException;
    public SettlePolicyCollection getSettlePolicyCollection(EntityViewInfo view) throws BOSException;
    public SettlePolicyCollection getSettlePolicyCollection(String oql) throws BOSException;
    public void isTemplate(SettlePolicyInfo model) throws BOSException;
    public void audit(SettlePolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(SettlePolicyInfo model) throws BOSException, EASBizException;
    public void mulUpdate(SettlePolicyInfo model) throws BOSException;
}