package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.hatch.HatchEggReceivingBillCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchEggReceivingBillController extends CoreBillBaseController
{
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(Context ctx) throws BOSException, RemoteException;
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, HatchEggReceivingBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, HatchEggReceivingBillInfo model) throws BOSException, RemoteException;
}