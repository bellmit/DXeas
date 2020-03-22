package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.salediscount.DiscountCustomerRelInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salediscount.DiscountCustomerRelCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DiscountCustomerRelController extends DataBaseController
{
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(Context ctx) throws BOSException, RemoteException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(Context ctx, String oql) throws BOSException, RemoteException;
}