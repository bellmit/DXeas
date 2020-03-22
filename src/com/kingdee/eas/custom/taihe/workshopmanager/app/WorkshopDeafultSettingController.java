package com.kingdee.eas.custom.taihe.workshopmanager.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.workshopmanager.WorkshopDeafultSettingCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.workshopmanager.WorkshopDeafultSettingInfo;
import java.lang.String;
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

public interface WorkshopDeafultSettingController extends WlhlDataBaseController
{
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WorkshopDeafultSettingInfo getWorkshopDeafultSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection(Context ctx) throws BOSException, RemoteException;
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WorkshopDeafultSettingCollection getWorkshopDeafultSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
}