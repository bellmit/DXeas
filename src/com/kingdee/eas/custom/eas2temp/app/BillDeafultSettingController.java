package com.kingdee.eas.custom.eas2temp.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingCollection;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BillDeafultSettingController extends DataBaseController
{
    public BillDeafultSettingInfo getBillDeafultSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingInfo getBillDeafultSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingInfo getBillDeafultSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection(Context ctx) throws BOSException, RemoteException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
}