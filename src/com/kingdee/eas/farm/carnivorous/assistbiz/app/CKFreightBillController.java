package com.kingdee.eas.farm.carnivorous.assistbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKFreightBillController extends CoreBillBaseController
{
    public CKFreightBillCollection getCKFreightBillCollection(Context ctx) throws BOSException, RemoteException;
    public CKFreightBillCollection getCKFreightBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKFreightBillCollection getCKFreightBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CKFreightBillInfo getCKFreightBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKFreightBillInfo getCKFreightBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKFreightBillInfo getCKFreightBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CKFreightBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CKFreightBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void calFreight(Context ctx, CKFreightBillInfo model) throws BOSException, EASBizException, RemoteException;
}