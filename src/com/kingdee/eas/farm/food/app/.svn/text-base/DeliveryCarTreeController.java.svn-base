package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.food.DeliveryCarTreeInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.food.DeliveryCarTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DeliveryCarTreeController extends TreeBaseController
{
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(Context ctx) throws BOSException, RemoteException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}