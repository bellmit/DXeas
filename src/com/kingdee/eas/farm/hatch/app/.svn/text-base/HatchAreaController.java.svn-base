package com.kingdee.eas.farm.hatch.app;

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
import com.kingdee.eas.farm.hatch.HatchAreaInfo;
import com.kingdee.eas.farm.hatch.HatchAreaCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchAreaController extends DataBaseController
{
    public HatchAreaInfo getHatchAreaInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchAreaInfo getHatchAreaInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchAreaInfo getHatchAreaInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public HatchAreaCollection getHatchAreaCollection(Context ctx) throws BOSException, RemoteException;
    public HatchAreaCollection getHatchAreaCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchAreaCollection getHatchAreaCollection(Context ctx, String oql) throws BOSException, RemoteException;
}