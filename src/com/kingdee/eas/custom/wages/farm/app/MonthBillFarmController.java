package com.kingdee.eas.custom.wages.farm.app;

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
import com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MonthBillFarmController extends CoreBillBaseController
{
    public MonthBillFarmCollection getMonthBillFarmCollection(Context ctx) throws BOSException, RemoteException;
    public MonthBillFarmCollection getMonthBillFarmCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MonthBillFarmCollection getMonthBillFarmCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public MonthBillFarmInfo getMonthBillFarmInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MonthBillFarmInfo getMonthBillFarmInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MonthBillFarmInfo getMonthBillFarmInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, MonthBillFarmInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, MonthBillFarmInfo model) throws BOSException, RemoteException;
    public void getPerson(Context ctx, MonthBillFarmInfo model) throws BOSException, RemoteException;
    public void wagecalculation(Context ctx, MonthBillFarmInfo model) throws BOSException, RemoteException;
}