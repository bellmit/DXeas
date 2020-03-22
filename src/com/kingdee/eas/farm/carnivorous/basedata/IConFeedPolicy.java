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

public interface IConFeedPolicy extends IDataBase
{
    public ConFeedPolicyInfo getConFeedPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConFeedPolicyInfo getConFeedPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConFeedPolicyInfo getConFeedPolicyInfo(String oql) throws BOSException, EASBizException;
    public ConFeedPolicyCollection getConFeedPolicyCollection() throws BOSException;
    public ConFeedPolicyCollection getConFeedPolicyCollection(EntityViewInfo view) throws BOSException;
    public ConFeedPolicyCollection getConFeedPolicyCollection(String oql) throws BOSException;
    public void audit(ConFeedPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(ConFeedPolicyInfo model) throws BOSException, EASBizException;
}