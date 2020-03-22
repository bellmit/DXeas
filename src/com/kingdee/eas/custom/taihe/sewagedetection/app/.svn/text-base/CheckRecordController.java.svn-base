package com.kingdee.eas.custom.taihe.sewagedetection.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CheckRecordController extends WlhlBillBaseController
{
    public CheckRecordCollection getCheckRecordCollection(Context ctx) throws BOSException, RemoteException;
    public CheckRecordCollection getCheckRecordCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CheckRecordCollection getCheckRecordCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CheckRecordInfo getCheckRecordInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CheckRecordInfo getCheckRecordInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CheckRecordInfo getCheckRecordInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void getCheckRecord(Context ctx, CheckRecordInfo model) throws BOSException, RemoteException;
    public void modileSee(Context ctx, CheckRecordInfo model) throws BOSException, RemoteException;
}