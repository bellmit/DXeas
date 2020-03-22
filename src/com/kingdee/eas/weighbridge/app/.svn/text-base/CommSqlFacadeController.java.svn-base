package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CommSqlFacadeController extends BizController
{
    public IRowSet executeQuery(Context ctx, String sqlStr) throws BOSException, RemoteException;
    public IRowSet executeQuery(Context ctx, String sqlStr, Object[] params) throws BOSException, RemoteException;
    public void execute(Context ctx, String sqlStr) throws BOSException, RemoteException;
    public void execute(Context ctx, String sqlStr, Object[] params) throws BOSException, RemoteException;
}