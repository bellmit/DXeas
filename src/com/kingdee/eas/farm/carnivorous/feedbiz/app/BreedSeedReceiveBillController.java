package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BreedSeedReceiveBillController extends CoreBillBaseController
{
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(Context ctx) throws BOSException, RemoteException;
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BreedSeedReceiveBillCollection getBreedSeedReceiveBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BreedSeedReceiveBillInfo getBreedSeedReceiveBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void chkVoucherFlag(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, RemoteException;
    public void chkVoucherAll(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, RemoteException;
    public void close(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unClose(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void updatePrice(Context ctx, BreedSeedReceiveBillInfo model) throws BOSException, RemoteException;
}