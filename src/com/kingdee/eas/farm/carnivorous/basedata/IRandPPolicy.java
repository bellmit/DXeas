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

public interface IRandPPolicy extends IDataBase
{
    public RandPPolicyInfo getRandPPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RandPPolicyInfo getRandPPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RandPPolicyInfo getRandPPolicyInfo(String oql) throws BOSException, EASBizException;
    public RandPPolicyCollection getRandPPolicyCollection() throws BOSException;
    public RandPPolicyCollection getRandPPolicyCollection(EntityViewInfo view) throws BOSException;
    public RandPPolicyCollection getRandPPolicyCollection(String oql) throws BOSException;
    public void audit(RandPPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(RandPPolicyInfo model) throws BOSException, EASBizException;
}