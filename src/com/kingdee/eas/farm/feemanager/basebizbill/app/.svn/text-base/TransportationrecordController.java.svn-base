package com.kingdee.eas.farm.feemanager.basebizbill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TransportationrecordController extends CoreBillBaseController
{
    public TransportationrecordCollection getTransportationrecordCollection(Context ctx) throws BOSException, RemoteException;
    public TransportationrecordCollection getTransportationrecordCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TransportationrecordCollection getTransportationrecordCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public TransportationrecordInfo getTransportationrecordInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TransportationrecordInfo getTransportationrecordInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TransportationrecordInfo getTransportationrecordInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, TransportationrecordInfo model) throws BOSException, EASBizException, RemoteException;
    public void auditback(Context ctx, TransportationrecordInfo model) throws BOSException, EASBizException, RemoteException;
    public void sendend(Context ctx, TransportationrecordInfo model) throws BOSException, EASBizException, RemoteException;
    public void calfright(Context ctx, TransportationrecordInfo model) throws BOSException, EASBizException, RemoteException;
    public void updateMileage(Context ctx, TransportationrecordInfo model) throws BOSException, RemoteException;
    public void appointPerson(Context ctx, TransportationrecordInfo model) throws BOSException, RemoteException;
    public void viewUpdateMileage(Context ctx, TransportationrecordInfo model) throws BOSException, RemoteException;
}