package com.kingdee.eas.custom.salepayment;

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

public interface ILongTimeArAmount extends ICoreBillBase
{
    public LongTimeArAmountCollection getLongTimeArAmountCollection() throws BOSException;
    public LongTimeArAmountCollection getLongTimeArAmountCollection(EntityViewInfo view) throws BOSException;
    public LongTimeArAmountCollection getLongTimeArAmountCollection(String oql) throws BOSException;
    public LongTimeArAmountInfo getLongTimeArAmountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LongTimeArAmountInfo getLongTimeArAmountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LongTimeArAmountInfo getLongTimeArAmountInfo(String oql) throws BOSException, EASBizException;
}