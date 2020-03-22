package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.hatch.HatchBabyBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.hatch.HatchBabyBillCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchBabyBillController extends CoreBillBaseController
{
    public HatchBabyBillCollection getHatchBabyBillCollection(Context ctx) throws BOSException, RemoteException;
    public HatchBabyBillCollection getHatchBabyBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchBabyBillCollection getHatchBabyBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public HatchBabyBillInfo getHatchBabyBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillInfo getHatchBabyBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillInfo getHatchBabyBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, HatchBabyBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, HatchBabyBillInfo model) throws BOSException, RemoteException;
}