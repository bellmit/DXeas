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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICustomerBalance extends IDataBase
{
    public CustomerBalanceInfo getCustomerBalanceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerBalanceInfo getCustomerBalanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerBalanceInfo getCustomerBalanceInfo(String oql) throws BOSException, EASBizException;
    public CustomerBalanceCollection getCustomerBalanceCollection() throws BOSException;
    public CustomerBalanceCollection getCustomerBalanceCollection(EntityViewInfo view) throws BOSException;
    public CustomerBalanceCollection getCustomerBalanceCollection(String oql) throws BOSException;
}