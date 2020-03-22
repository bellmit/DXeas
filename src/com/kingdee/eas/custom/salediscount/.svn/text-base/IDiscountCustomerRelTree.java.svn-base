package com.kingdee.eas.custom.salediscount;

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

public interface IDiscountCustomerRelTree extends ITreeBase
{
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(String oql) throws BOSException, EASBizException;
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection() throws BOSException;
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection(EntityViewInfo view) throws BOSException;
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection(String oql) throws BOSException;
}