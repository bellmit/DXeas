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

public interface IDiscountCompany extends IDataBase
{
    public DiscountCompanyInfo getDiscountCompanyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountCompanyInfo getDiscountCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountCompanyInfo getDiscountCompanyInfo(String oql) throws BOSException, EASBizException;
    public DiscountCompanyCollection getDiscountCompanyCollection() throws BOSException;
    public DiscountCompanyCollection getDiscountCompanyCollection(EntityViewInfo view) throws BOSException;
    public DiscountCompanyCollection getDiscountCompanyCollection(String oql) throws BOSException;
}