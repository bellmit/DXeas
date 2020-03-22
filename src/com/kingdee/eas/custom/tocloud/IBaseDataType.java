package com.kingdee.eas.custom.tocloud;

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

public interface IBaseDataType extends IDataBase
{
    public BaseDataTypeInfo getBaseDataTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseDataTypeInfo getBaseDataTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseDataTypeInfo getBaseDataTypeInfo(String oql) throws BOSException, EASBizException;
    public BaseDataTypeCollection getBaseDataTypeCollection() throws BOSException;
    public BaseDataTypeCollection getBaseDataTypeCollection(EntityViewInfo view) throws BOSException;
    public BaseDataTypeCollection getBaseDataTypeCollection(String oql) throws BOSException;
}