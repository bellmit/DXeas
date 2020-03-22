package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKWeightBillController extends CoreBillBaseController
{
    public CKWeightBillCollection getCKWeightBillCollection(Context ctx) throws BOSException, RemoteException;
    public CKWeightBillCollection getCKWeightBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKWeightBillCollection getCKWeightBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CKWeightBillInfo getCKWeightBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKWeightBillInfo getCKWeightBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKWeightBillInfo getCKWeightBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CKWeightBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, CKWeightBillInfo model) throws BOSException, RemoteException;
    public void updateSourceBill(Context ctx, CKWeightBillInfo model) throws BOSException, RemoteException;
}