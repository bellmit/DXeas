package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface HatchBaseDataController extends DataBaseController
{
    public HatchBaseDataInfo getHatchBaseDataInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataInfo getHatchBaseDataInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataInfo getHatchBaseDataInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataCollection getHatchBaseDataCollection(Context ctx) throws BOSException, RemoteException;
    public HatchBaseDataCollection getHatchBaseDataCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchBaseDataCollection getHatchBaseDataCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, HatchBaseDataInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, HatchBaseDataInfo model) throws BOSException, RemoteException;
}