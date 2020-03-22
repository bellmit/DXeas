package com.kingdee.eas.custom.taihe.vehicledetection.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface VcWhiteListTreeController extends TreeBaseController
{
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection(Context ctx) throws BOSException, RemoteException;
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}