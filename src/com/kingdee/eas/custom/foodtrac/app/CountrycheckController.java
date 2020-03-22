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
import com.kingdee.eas.custom.foodtrac.CountrycheckCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.foodtrac.CountrycheckInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CountrycheckController extends CoreBillBaseController
{
    public CountrycheckCollection getCountrycheckCollection(Context ctx) throws BOSException, RemoteException;
    public CountrycheckCollection getCountrycheckCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CountrycheckCollection getCountrycheckCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CountrycheckInfo getCountrycheckInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CountrycheckInfo getCountrycheckInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CountrycheckInfo getCountrycheckInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}