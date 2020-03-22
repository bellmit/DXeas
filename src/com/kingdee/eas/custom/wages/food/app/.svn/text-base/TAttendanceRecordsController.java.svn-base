package com.kingdee.eas.custom.wages.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wages.food.TAttendanceRecordsInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.wages.food.TAttendanceRecordsCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TAttendanceRecordsController extends CoreBillBaseController
{
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(Context ctx) throws BOSException, RemoteException;
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, TAttendanceRecordsInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, TAttendanceRecordsInfo model) throws BOSException, RemoteException;
}