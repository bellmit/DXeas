package com.kingdee.eas.custom.taihe.settle.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.settle.SettleBillCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.eas.custom.taihe.settle.SettleBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettleBillController extends WlhlBillBaseController
{
    public SettleBillCollection getSettleBillCollection(Context ctx) throws BOSException, RemoteException;
    public SettleBillCollection getSettleBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettleBillCollection getSettleBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettleBillInfo getSettleBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, SettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void execute(Context ctx, SettleBillInfo model) throws BOSException, RemoteException;
}