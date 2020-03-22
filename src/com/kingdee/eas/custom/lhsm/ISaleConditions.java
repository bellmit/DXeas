package com.kingdee.eas.custom.lhsm;

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

public interface ISaleConditions extends IDataBase
{
    public SaleConditionsInfo getSaleConditionsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleConditionsInfo getSaleConditionsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleConditionsInfo getSaleConditionsInfo(String oql) throws BOSException, EASBizException;
    public SaleConditionsCollection getSaleConditionsCollection() throws BOSException;
    public SaleConditionsCollection getSaleConditionsCollection(EntityViewInfo view) throws BOSException;
    public SaleConditionsCollection getSaleConditionsCollection(String oql) throws BOSException;
}