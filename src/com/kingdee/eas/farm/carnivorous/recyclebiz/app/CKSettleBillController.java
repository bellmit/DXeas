package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillCollection;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
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

public interface CKSettleBillController extends CoreBillBaseController
{
    public CKSettleBillCollection getCKSettleBillCollection(Context ctx) throws BOSException, RemoteException;
    public CKSettleBillCollection getCKSettleBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKSettleBillCollection getCKSettleBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CKSettleBillInfo getCKSettleBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKSettleBillInfo getCKSettleBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKSettleBillInfo getCKSettleBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void close(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unClose(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public Map execSettle(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void updateSaleData(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public Map updateActAmt(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void updateSale(Context ctx, CKSettleBillInfo model) throws BOSException, RemoteException;
    public void hasPay(Context ctx, CKSettleBillInfo model) throws BOSException, EASBizException, RemoteException;
}