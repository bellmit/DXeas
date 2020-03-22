package com.kingdee.eas.custom.lhsm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ForecasetTransOrderFacadeController extends BizController
{
    public String getAllData(Context ctx, String param) throws BOSException, RemoteException;
    public String getSingleForecastData(Context ctx, String param) throws BOSException, RemoteException;
    public String addSaleOrderBill(Context ctx, String param) throws BOSException, RemoteException;
    public String getMaterialInventory(Context ctx, String param) throws BOSException, RemoteException;
    public String excuteQuerySql(Context ctx, String param) throws BOSException, RemoteException;
    public String excuteInsertSql(Context ctx, String param) throws BOSException, RemoteException;
    public String excuteInsertSql(Context ctx, String sql, Object[] obj) throws BOSException, RemoteException;
}