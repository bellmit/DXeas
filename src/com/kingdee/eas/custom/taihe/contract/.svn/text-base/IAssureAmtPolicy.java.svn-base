package com.kingdee.eas.custom.taihe.contract;

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

public interface IAssureAmtPolicy extends IDataBase
{
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(String oql) throws BOSException, EASBizException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection() throws BOSException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(EntityViewInfo view) throws BOSException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(String oql) throws BOSException;
    public void audit(AssureAmtPolicyInfo model) throws BOSException;
    public void unAudit(AssureAmtPolicyInfo model) throws BOSException;
}