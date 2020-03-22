package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
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

public interface ICustomerBalanceEditEntry extends ICoreBillEntryBase
{
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(String oql) throws BOSException, EASBizException;
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection() throws BOSException;
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection(EntityViewInfo view) throws BOSException;
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection(String oql) throws BOSException;
}