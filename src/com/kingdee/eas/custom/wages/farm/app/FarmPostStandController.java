package com.kingdee.eas.custom.wages.farm.app;

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
import com.kingdee.eas.custom.wages.farm.FarmPostStandCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.farm.FarmPostStandInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmPostStandController extends DataBaseController
{
    public FarmPostStandInfo getFarmPostStandInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmPostStandInfo getFarmPostStandInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmPostStandInfo getFarmPostStandInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FarmPostStandCollection getFarmPostStandCollection(Context ctx) throws BOSException, RemoteException;
    public FarmPostStandCollection getFarmPostStandCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmPostStandCollection getFarmPostStandCollection(Context ctx, String oql) throws BOSException, RemoteException;
}