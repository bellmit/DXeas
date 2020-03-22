package com.kingdee.eas.custom.salaryvoucher.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SalaryVoucherController extends CoreBillBaseController
{
    public SalaryVoucherCollection getSalaryVoucherCollection(Context ctx) throws BOSException, RemoteException;
    public SalaryVoucherCollection getSalaryVoucherCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SalaryVoucherCollection getSalaryVoucherCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SalaryVoucherInfo getSalaryVoucherInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SalaryVoucherInfo getSalaryVoucherInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SalaryVoucherInfo getSalaryVoucherInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void toSalaryVoucher(Context ctx, SalaryVoucherInfo model) throws BOSException, RemoteException;
}