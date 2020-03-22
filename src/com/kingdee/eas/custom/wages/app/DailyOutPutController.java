package com.kingdee.eas.custom.wages.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wages.DailyOutPutCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.custom.wages.DailyOutPutInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DailyOutPutController extends CoreBillBaseController
{
    public DailyOutPutCollection getDailyOutPutCollection(Context ctx) throws BOSException, RemoteException;
    public DailyOutPutCollection getDailyOutPutCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DailyOutPutCollection getDailyOutPutCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DailyOutPutInfo getDailyOutPutInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DailyOutPutInfo getDailyOutPutInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DailyOutPutInfo getDailyOutPutInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DailyOutPutInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, DailyOutPutInfo model) throws BOSException, RemoteException;
    public void salaryCount(Context ctx, DailyOutPutInfo model) throws BOSException, RemoteException;
}