package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
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

public interface DrugReceiveBillController extends CoreBillBaseController
{
    public DrugReceiveBillCollection getDrugReceiveBillCollection(Context ctx) throws BOSException, RemoteException;
    public DrugReceiveBillCollection getDrugReceiveBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DrugReceiveBillCollection getDrugReceiveBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DrugReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, DrugReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void chkVoucherAll(Context ctx, DrugReceiveBillInfo model) throws BOSException, RemoteException;
    public void chkVoucherFlag(Context ctx, DrugReceiveBillInfo model) throws BOSException, RemoteException;
    public void close(Context ctx, DrugReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unClose(Context ctx, DrugReceiveBillInfo model) throws BOSException, EASBizException, RemoteException;
}