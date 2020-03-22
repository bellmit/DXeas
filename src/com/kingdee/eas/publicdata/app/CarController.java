package com.kingdee.eas.publicdata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.publicdata.CarCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CarController extends DataBaseController
{
    public CarInfo getCarInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CarInfo getCarInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CarInfo getCarInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CarCollection getCarCollection(Context ctx) throws BOSException, RemoteException;
    public CarCollection getCarCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CarCollection getCarCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void review(Context ctx, CarInfo model) throws BOSException, RemoteException;
    public void unreview(Context ctx, CarInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, CarInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CarInfo model) throws BOSException, EASBizException, RemoteException;
}