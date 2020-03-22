package com.kingdee.eas.custom.wages.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.EmploySecurityInfo;
import com.kingdee.eas.custom.wages.EmploySecurityCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EmploySecurityController extends CoreBillBaseController
{
    public EmploySecurityCollection getEmploySecurityCollection(Context ctx) throws BOSException, RemoteException;
    public EmploySecurityCollection getEmploySecurityCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public EmploySecurityCollection getEmploySecurityCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public EmploySecurityInfo getEmploySecurityInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public EmploySecurityInfo getEmploySecurityInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public EmploySecurityInfo getEmploySecurityInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, EmploySecurityInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, EmploySecurityInfo model) throws BOSException, RemoteException;
}