package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.hatch.TranferBoxBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.hatch.TranferBoxBillCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TranferBoxBillController extends CoreBillBaseController
{
    public TranferBoxBillCollection getTranferBoxBillCollection(Context ctx) throws BOSException, RemoteException;
    public TranferBoxBillCollection getTranferBoxBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TranferBoxBillCollection getTranferBoxBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public TranferBoxBillInfo getTranferBoxBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TranferBoxBillInfo getTranferBoxBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TranferBoxBillInfo getTranferBoxBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, TranferBoxBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, TranferBoxBillInfo model) throws BOSException, RemoteException;
}