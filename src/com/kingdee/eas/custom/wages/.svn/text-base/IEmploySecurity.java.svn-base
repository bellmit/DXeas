package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IEmploySecurity extends ICoreBillBase
{
    public EmploySecurityCollection getEmploySecurityCollection() throws BOSException;
    public EmploySecurityCollection getEmploySecurityCollection(EntityViewInfo view) throws BOSException;
    public EmploySecurityCollection getEmploySecurityCollection(String oql) throws BOSException;
    public EmploySecurityInfo getEmploySecurityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EmploySecurityInfo getEmploySecurityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EmploySecurityInfo getEmploySecurityInfo(String oql) throws BOSException, EASBizException;
    public void audit(EmploySecurityInfo model) throws BOSException;
    public void unaudit(EmploySecurityInfo model) throws BOSException;
}