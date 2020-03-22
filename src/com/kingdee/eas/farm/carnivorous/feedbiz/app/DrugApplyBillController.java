package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface DrugApplyBillController extends CoreBillBaseController
{
    public DrugApplyBillCollection getDrugApplyBillCollection(Context ctx) throws BOSException, RemoteException;
    public DrugApplyBillCollection getDrugApplyBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DrugApplyBillCollection getDrugApplyBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DrugApplyBillInfo getDrugApplyBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DrugApplyBillInfo getDrugApplyBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DrugApplyBillInfo getDrugApplyBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DrugApplyBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, DrugApplyBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void close(Context ctx, DrugApplyBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unClose(Context ctx, DrugApplyBillInfo model) throws BOSException, EASBizException, RemoteException;
}