package com.kingdee.eas.custom.szcount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.szcount.CountPosOtherCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.szcount.CountPosOtherInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CountPosOtherController extends WlhlDataBaseController
{
    public CountPosOtherInfo getCountPosOtherInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CountPosOtherInfo getCountPosOtherInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CountPosOtherInfo getCountPosOtherInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CountPosOtherCollection getCountPosOtherCollection(Context ctx) throws BOSException, RemoteException;
    public CountPosOtherCollection getCountPosOtherCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CountPosOtherCollection getCountPosOtherCollection(Context ctx, String oql) throws BOSException, RemoteException;
}