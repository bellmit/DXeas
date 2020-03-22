package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
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

public interface ICountPostProducts extends IWlhlDataBase
{
    public CountPostProductsInfo getCountPostProductsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CountPostProductsInfo getCountPostProductsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CountPostProductsInfo getCountPostProductsInfo(String oql) throws BOSException, EASBizException;
    public CountPostProductsCollection getCountPostProductsCollection() throws BOSException;
    public CountPostProductsCollection getCountPostProductsCollection(EntityViewInfo view) throws BOSException;
    public CountPostProductsCollection getCountPostProductsCollection(String oql) throws BOSException;
}