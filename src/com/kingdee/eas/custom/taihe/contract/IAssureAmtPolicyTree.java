package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAssureAmtPolicyTree extends ITreeBase
{
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(String oql) throws BOSException, EASBizException;
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection() throws BOSException;
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection(EntityViewInfo view) throws BOSException;
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection(String oql) throws BOSException;
}