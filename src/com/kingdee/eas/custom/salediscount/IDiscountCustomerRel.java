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

public interface IDiscountCustomerRel extends IDataBase
{
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(String oql) throws BOSException, EASBizException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection() throws BOSException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(EntityViewInfo view) throws BOSException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(String oql) throws BOSException;
}