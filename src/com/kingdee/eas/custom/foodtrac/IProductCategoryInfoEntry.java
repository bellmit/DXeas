package com.kingdee.eas.custom.foodtrac;

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

public interface IProductCategoryInfoEntry extends ICoreBillEntryBase
{
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(String oql) throws BOSException, EASBizException;
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection() throws BOSException;
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection(EntityViewInfo view) throws BOSException;
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection(String oql) throws BOSException;
}