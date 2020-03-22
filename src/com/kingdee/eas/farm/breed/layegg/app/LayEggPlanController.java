package com.kingdee.eas.farm.breed.layegg.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LayEggPlanController extends CoreBillBaseController
{
    public LayEggPlanCollection getLayEggPlanCollection(Context ctx) throws BOSException, RemoteException;
    public LayEggPlanCollection getLayEggPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public LayEggPlanCollection getLayEggPlanCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public LayEggPlanInfo getLayEggPlanInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public LayEggPlanInfo getLayEggPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public LayEggPlanInfo getLayEggPlanInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, LayEggPlanInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, LayEggPlanInfo model) throws BOSException, RemoteException;
}