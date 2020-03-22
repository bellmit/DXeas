package com.kingdee.eas.custom.taihe.workshopmanager.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LoadingBillController extends WlhlBillBaseController
{
    public LoadingBillCollection getLoadingBillCollection(Context ctx) throws BOSException, RemoteException;
    public LoadingBillCollection getLoadingBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public LoadingBillCollection getLoadingBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public LoadingBillInfo getLoadingBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public LoadingBillInfo getLoadingBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public LoadingBillInfo getLoadingBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void mobileQuery(Context ctx, LoadingBillInfo model) throws BOSException, RemoteException;
    public void mobifyAddNew(Context ctx, LoadingBillInfo model) throws BOSException, RemoteException;
}