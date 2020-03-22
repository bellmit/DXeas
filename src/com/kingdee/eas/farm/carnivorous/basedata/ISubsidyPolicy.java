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

public interface ISubsidyPolicy extends IDataBase
{
    public SubsidyPolicyInfo getSubsidyPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SubsidyPolicyInfo getSubsidyPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SubsidyPolicyInfo getSubsidyPolicyInfo(String oql) throws BOSException, EASBizException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection() throws BOSException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection(EntityViewInfo view) throws BOSException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection(String oql) throws BOSException;
    public void audit(SubsidyPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(SubsidyPolicyInfo model) throws BOSException, EASBizException;
}