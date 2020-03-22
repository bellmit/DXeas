package com.kingdee.eas.farm.breed.app;

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
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HenhouseController extends CoreBillBaseController
{
    public HenhouseCollection getHenhouseCollection(Context ctx) throws BOSException, RemoteException;
    public HenhouseCollection getHenhouseCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HenhouseCollection getHenhouseCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public HenhouseInfo getHenhouseInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HenhouseInfo getHenhouseInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HenhouseInfo getHenhouseInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}