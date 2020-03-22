package com.kingdee.eas.custom.settlebill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.settlebill.SettleBillCollection;
import com.kingdee.eas.custom.settlebill.SettleBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface SettleBillController extends CoreBillBaseController
{
    public SettleBillCollection getSettleBillCollection(Context ctx) throws BOSException, RemoteException;
    public SettleBillCollection getSettleBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettleBillCollection getSettleBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void getCostAmt(Context ctx, SettleBillInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, SettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void checkVoucher(Context ctx, SettleBillInfo model) throws BOSException, RemoteException;
    public void exeSet(Context ctx, SettleBillInfo model) throws BOSException, RemoteException;
}