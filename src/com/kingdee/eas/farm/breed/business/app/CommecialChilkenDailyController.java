package com.kingdee.eas.farm.breed.business.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyCollection;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CommecialChilkenDailyController extends CoreBillBaseController
{
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(Context ctx) throws BOSException, RemoteException;
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CommecialChilkenDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, CommecialChilkenDailyInfo model) throws BOSException, RemoteException;
    public List genNextBill(Context ctx, CommecialChilkenDailyInfo model) throws BOSException, RemoteException;
}