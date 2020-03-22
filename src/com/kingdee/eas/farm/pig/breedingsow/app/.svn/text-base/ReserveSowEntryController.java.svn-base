package com.kingdee.eas.farm.pig.breedingsow.app;

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
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ReserveSowEntryController extends CoreBillEntryBaseController
{
    public ReserveSowEntryInfo getReserveSowEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ReserveSowEntryInfo getReserveSowEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ReserveSowEntryInfo getReserveSowEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ReserveSowEntryCollection getReserveSowEntryCollection(Context ctx) throws BOSException, RemoteException;
    public ReserveSowEntryCollection getReserveSowEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ReserveSowEntryCollection getReserveSowEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}