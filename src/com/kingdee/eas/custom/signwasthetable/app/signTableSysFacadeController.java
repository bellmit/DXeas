package com.kingdee.eas.custom.signwasthetable.app;

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

public interface signTableSysFacadeController extends BizController
{
    public void signTypeCancel(Context ctx, String id) throws BOSException, RemoteException;
    public void signTypeCancelcancel(Context ctx, String id) throws BOSException, RemoteException;
    public void engProjectCancel(Context ctx, String id) throws BOSException, RemoteException;
    public void engProjectCancelCancel(Context ctx, String id) throws BOSException, RemoteException;
    public void cTypeCancel(Context ctx, String id) throws BOSException, RemoteException;
    public void cTypeCancelCancel(Context ctx, String id) throws BOSException, RemoteException;
}