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

public interface ITempPolicy extends IDataBase
{
    public TempPolicyInfo getTempPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TempPolicyInfo getTempPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TempPolicyInfo getTempPolicyInfo(String oql) throws BOSException, EASBizException;
    public TempPolicyCollection getTempPolicyCollection() throws BOSException;
    public TempPolicyCollection getTempPolicyCollection(EntityViewInfo view) throws BOSException;
    public TempPolicyCollection getTempPolicyCollection(String oql) throws BOSException;
    public void audit(TempPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(TempPolicyInfo model) throws BOSException, EASBizException;
}