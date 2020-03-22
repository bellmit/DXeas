package com.kingdee.eas.custom.taihe.settle.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyCollection;
import com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TaiHeSettlePolicyController extends WlhlDataBaseController
{
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TaiHeSettlePolicyInfo getTaiHeSettlePolicyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection(Context ctx) throws BOSException, RemoteException;
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TaiHeSettlePolicyCollection getTaiHeSettlePolicyCollection(Context ctx, String oql) throws BOSException, RemoteException;
}