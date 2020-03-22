package com.kingdee.eas.farm.stocking.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EggSettleBillController extends CoreBillBaseController
{
    public EggSettleBillCollection getEggSettleBillCollection(Context ctx) throws BOSException, RemoteException;
    public EggSettleBillCollection getEggSettleBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public EggSettleBillCollection getEggSettleBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public EggSettleBillInfo getEggSettleBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public EggSettleBillInfo getEggSettleBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public EggSettleBillInfo getEggSettleBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, EggSettleBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, EggSettleBillInfo model) throws BOSException, RemoteException;
    public void showPriceCol(Context ctx, EggSettleBillInfo model) throws BOSException, RemoteException;
    public void exeSettle(Context ctx, EggSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void batchSubmit(Context ctx, EggSettleBillInfo model) throws BOSException, RemoteException;
}