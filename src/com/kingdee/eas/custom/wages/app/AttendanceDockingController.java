package com.kingdee.eas.custom.wages.app;

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
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.AttendanceDockingCollection;
import com.kingdee.eas.custom.wages.AttendanceDockingInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AttendanceDockingController extends WlhlBillBaseController
{
    public AttendanceDockingCollection getAttendanceDockingCollection(Context ctx) throws BOSException, RemoteException;
    public AttendanceDockingCollection getAttendanceDockingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AttendanceDockingCollection getAttendanceDockingCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AttendanceDockingInfo getAttendanceDockingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AttendanceDockingInfo getAttendanceDockingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AttendanceDockingInfo getAttendanceDockingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}