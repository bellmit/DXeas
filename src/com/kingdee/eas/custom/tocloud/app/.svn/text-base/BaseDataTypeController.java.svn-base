package com.kingdee.eas.custom.tocloud.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.tocloud.BaseDataTypeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.tocloud.BaseDataTypeInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BaseDataTypeController extends DataBaseController
{
    public BaseDataTypeInfo getBaseDataTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BaseDataTypeInfo getBaseDataTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BaseDataTypeInfo getBaseDataTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BaseDataTypeCollection getBaseDataTypeCollection(Context ctx) throws BOSException, RemoteException;
    public BaseDataTypeCollection getBaseDataTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BaseDataTypeCollection getBaseDataTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}