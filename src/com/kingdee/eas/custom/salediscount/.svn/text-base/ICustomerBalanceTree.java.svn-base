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

public interface ICustomerBalanceTree extends ITreeBase
{
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(String oql) throws BOSException, EASBizException;
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection() throws BOSException;
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection(EntityViewInfo view) throws BOSException;
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection(String oql) throws BOSException;
}