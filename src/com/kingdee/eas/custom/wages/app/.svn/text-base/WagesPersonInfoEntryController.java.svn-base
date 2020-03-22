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
import com.kingdee.eas.custom.wages.WagesPersonInfoEntryInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.WagesPersonInfoEntryCollection;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WagesPersonInfoEntryController extends CoreBillEntryBaseController
{
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection(Context ctx) throws BOSException, RemoteException;
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}