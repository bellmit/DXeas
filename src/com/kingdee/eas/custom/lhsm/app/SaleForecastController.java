package com.kingdee.eas.custom.lhsm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.lhsm.SaleForecastCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.lhsm.SaleForecastInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SaleForecastController extends CoreBillBaseController
{
    public SaleForecastCollection getSaleForecastCollection(Context ctx) throws BOSException, RemoteException;
    public SaleForecastCollection getSaleForecastCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SaleForecastCollection getSaleForecastCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SaleForecastInfo getSaleForecastInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SaleForecastInfo getSaleForecastInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SaleForecastInfo getSaleForecastInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, SaleForecastInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SaleForecastInfo model) throws BOSException, EASBizException, RemoteException;
    public void progressView(Context ctx, SaleForecastInfo model) throws BOSException, RemoteException;
    public void viewPro(Context ctx, SaleForecastInfo model) throws BOSException, RemoteException;
}