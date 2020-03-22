package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface StatementsBillController extends CoreBillBaseController
{
    public StatementsBillCollection getStatementsBillCollection(Context ctx) throws BOSException, RemoteException;
    public StatementsBillCollection getStatementsBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public StatementsBillCollection getStatementsBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public StatementsBillInfo getStatementsBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public StatementsBillInfo getStatementsBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public StatementsBillInfo getStatementsBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
    public Object btnExeCal(Context ctx, StatementsBillInfo model) throws BOSException, EASBizException, RemoteException;
    public Object exeAllCal(Context ctx, Object param) throws BOSException, EASBizException, RemoteException;
    public void multiSubmit(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
    public void breateBill(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
    public void calYC(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
    public void carryover(Context ctx, StatementsBillInfo model) throws BOSException, RemoteException;
}