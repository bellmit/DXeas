package com.kingdee.eas.custom.salediscount;

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

public interface ICustomerBalanceEdit extends ICoreBillBase
{
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection() throws BOSException;
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection(EntityViewInfo view) throws BOSException;
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection(String oql) throws BOSException;
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(String oql) throws BOSException, EASBizException;
    public void audit(CustomerBalanceEditInfo model) throws BOSException;
    public void unAudit(CustomerBalanceEditInfo model) throws BOSException;
}