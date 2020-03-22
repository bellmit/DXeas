package com.kingdee.eas.farm.food.stocount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.food.stocount.CountPositionSetCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.food.stocount.CountPositionSetInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CountPositionSetController extends DataBaseController
{
    public CountPositionSetInfo getCountPositionSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CountPositionSetInfo getCountPositionSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CountPositionSetInfo getCountPositionSetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CountPositionSetCollection getCountPositionSetCollection(Context ctx) throws BOSException, RemoteException;
    public CountPositionSetCollection getCountPositionSetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CountPositionSetCollection getCountPositionSetCollection(Context ctx, String oql) throws BOSException, RemoteException;
}