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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFeeType extends IDataBase
{
    public FeeTypeInfo getFeeTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeeTypeInfo getFeeTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeeTypeInfo getFeeTypeInfo(String oql) throws BOSException, EASBizException;
    public FeeTypeCollection getFeeTypeCollection() throws BOSException;
    public FeeTypeCollection getFeeTypeCollection(EntityViewInfo view) throws BOSException;
    public FeeTypeCollection getFeeTypeCollection(String oql) throws BOSException;
}