package com.kingdee.eas.custom.taihe.vehicledetection.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface VdChannelSettingTreeController extends TreeBaseController
{
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection(Context ctx) throws BOSException, RemoteException;
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}