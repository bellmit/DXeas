package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.food.CManufactureBillInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.food.CManufactureBillCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.im.inv.app.InvBillBaseController;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CManufactureBillController extends InvBillBaseController
{
    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CManufactureBillCollection getCManufactureBillCollection(Context ctx) throws BOSException, RemoteException;
    public CManufactureBillCollection getCManufactureBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CManufactureBillCollection getCManufactureBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CManufactureBillInfo getDefaultCostObject(Context ctx, String materialId, String companyId, String lot) throws BOSException, EASBizException, RemoteException;
    public int associateManufactureRecBill(Context ctx, String fsourcebillid) throws BOSException, EASBizException, RemoteException;
}