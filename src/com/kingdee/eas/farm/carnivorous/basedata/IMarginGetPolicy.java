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

public interface IMarginGetPolicy extends IDataBase
{
    public MarginGetPolicyInfo getMarginGetPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginGetPolicyInfo getMarginGetPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginGetPolicyInfo getMarginGetPolicyInfo(String oql) throws BOSException, EASBizException;
    public MarginGetPolicyCollection getMarginGetPolicyCollection() throws BOSException;
    public MarginGetPolicyCollection getMarginGetPolicyCollection(EntityViewInfo view) throws BOSException;
    public MarginGetPolicyCollection getMarginGetPolicyCollection(String oql) throws BOSException;
    public void audtit(MarginGetPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(MarginGetPolicyInfo model) throws BOSException, EASBizException;
}