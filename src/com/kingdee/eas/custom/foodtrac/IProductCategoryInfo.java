package com.kingdee.eas.custom.foodtrac;

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

public interface IProductCategoryInfo extends ICoreBillBase
{
    public ProductCategoryInfoCollection getProductCategoryInfoCollection() throws BOSException;
    public ProductCategoryInfoCollection getProductCategoryInfoCollection(EntityViewInfo view) throws BOSException;
    public ProductCategoryInfoCollection getProductCategoryInfoCollection(String oql) throws BOSException;
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(String oql) throws BOSException, EASBizException;
}