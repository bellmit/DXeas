package com.kingdee.eas.custom.dx.weight;

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

public interface IStapleSupplier extends IWlhlDataBase
{
    public StapleSupplierInfo getStapleSupplierInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StapleSupplierInfo getStapleSupplierInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StapleSupplierInfo getStapleSupplierInfo(String oql) throws BOSException, EASBizException;
    public StapleSupplierCollection getStapleSupplierCollection() throws BOSException;
    public StapleSupplierCollection getStapleSupplierCollection(EntityViewInfo view) throws BOSException;
    public StapleSupplierCollection getStapleSupplierCollection(String oql) throws BOSException;
}