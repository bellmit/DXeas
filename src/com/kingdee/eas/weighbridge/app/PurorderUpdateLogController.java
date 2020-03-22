package com.kingdee.eas.weighbridge.app;

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
import com.kingdee.eas.weighbridge.PurorderUpdateLogCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.weighbridge.PurorderUpdateLogInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PurorderUpdateLogController extends DataBaseController
{
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(Context ctx) throws BOSException, RemoteException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(Context ctx, String oql) throws BOSException, RemoteException;
}