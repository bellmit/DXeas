package com.kingdee.eas.custom.taihe.basesetting.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingInfo;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TaiheBaseSettingController extends WlhlDataBaseController
{
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(Context ctx) throws BOSException, RemoteException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
}