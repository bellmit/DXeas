package com.kingdee.eas.custom.rentalapplicationform.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarCollection;
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

public interface RentalApplicationOfBusinessCarController extends CoreBillBaseController
{
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(Context ctx) throws BOSException, RemoteException;
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException, RemoteException;
}