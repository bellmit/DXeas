package com.kingdee.eas.farm.feemanager.basebizbill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TransportationrecordEntryController extends CoreBillEntryBaseController
{
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection(Context ctx) throws BOSException, RemoteException;
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}