package com.kingdee.eas.farm.stocking.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EggReceiveBillController extends CoreBillBaseController
{
    public EggReceiveBillCollection getEggReceiveBillCollection(Context ctx) throws BOSException, RemoteException;
    public EggReceiveBillCollection getEggReceiveBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public EggReceiveBillCollection getEggReceiveBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public EggReceiveBillInfo getEggReceiveBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public EggReceiveBillInfo getEggReceiveBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public EggReceiveBillInfo getEggReceiveBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void showPriceCol(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void viewAllBill(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void deleteDownBill(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void toSettleBill(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
    public void setColor(Context ctx, EggReceiveBillInfo model) throws BOSException, RemoteException;
}