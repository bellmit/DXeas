package com.kingdee.eas.farm.foodtrac.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.foodtrac.FarmCodeInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.foodtrac.FarmCodeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmCodeController extends DataBaseController
{
    public FarmCodeInfo getFarmCodeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmCodeInfo getFarmCodeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmCodeInfo getFarmCodeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FarmCodeCollection getFarmCodeCollection(Context ctx) throws BOSException, RemoteException;
    public FarmCodeCollection getFarmCodeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmCodeCollection getFarmCodeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}