package com.kingdee.eas.custom.foodtrac.app;

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
import com.kingdee.eas.custom.foodtrac.CountrycheckEntryCollection;
import com.kingdee.eas.custom.foodtrac.CountrycheckEntryInfo;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CountrycheckEntryController extends CoreBillEntryBaseController
{
    public CountrycheckEntryInfo getCountrycheckEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CountrycheckEntryInfo getCountrycheckEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CountrycheckEntryInfo getCountrycheckEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CountrycheckEntryCollection getCountrycheckEntryCollection(Context ctx) throws BOSException, RemoteException;
    public CountrycheckEntryCollection getCountrycheckEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CountrycheckEntryCollection getCountrycheckEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}