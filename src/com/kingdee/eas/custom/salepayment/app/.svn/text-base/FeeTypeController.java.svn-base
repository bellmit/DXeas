package com.kingdee.eas.custom.salepayment.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.salepayment.FeeTypeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salepayment.FeeTypeInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeeTypeController extends DataBaseController
{
    public FeeTypeInfo getFeeTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeeTypeInfo getFeeTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeeTypeInfo getFeeTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FeeTypeCollection getFeeTypeCollection(Context ctx) throws BOSException, RemoteException;
    public FeeTypeCollection getFeeTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeeTypeCollection getFeeTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}