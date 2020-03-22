package com.kingdee.eas.farm.stocking.basebizbill.app;

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
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryCollection;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MarginBillEntryController extends CoreBillEntryBaseController
{
    public MarginBillEntryInfo getMarginBillEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MarginBillEntryInfo getMarginBillEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MarginBillEntryInfo getMarginBillEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MarginBillEntryCollection getMarginBillEntryCollection(Context ctx) throws BOSException, RemoteException;
    public MarginBillEntryCollection getMarginBillEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MarginBillEntryCollection getMarginBillEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}