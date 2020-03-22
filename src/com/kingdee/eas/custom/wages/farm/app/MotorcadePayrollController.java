package com.kingdee.eas.custom.wages.farm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.farm.MotorcadePayrollCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MotorcadePayrollController extends CoreBillBaseController
{
    public MotorcadePayrollCollection getMotorcadePayrollCollection(Context ctx) throws BOSException, RemoteException;
    public MotorcadePayrollCollection getMotorcadePayrollCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MotorcadePayrollCollection getMotorcadePayrollCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, MotorcadePayrollInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, MotorcadePayrollInfo model) throws BOSException, RemoteException;
}