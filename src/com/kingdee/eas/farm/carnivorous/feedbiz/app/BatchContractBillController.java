package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BatchContractBillController extends CoreBillBaseController
{
    public BatchContractBillCollection getBatchContractBillCollection(Context ctx) throws BOSException, RemoteException;
    public BatchContractBillCollection getBatchContractBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BatchContractBillCollection getBatchContractBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BatchContractBillInfo getBatchContractBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BatchContractBillInfo getBatchContractBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BatchContractBillInfo getBatchContractBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BatchContractBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BatchContractBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void isTemplate(Context ctx, BatchContractBillInfo model) throws BOSException, RemoteException;
    public void isInit(Context ctx, BatchContractBillInfo model) throws BOSException, RemoteException;
    public void viewGuaranteeBill(Context ctx, BatchContractBillInfo model) throws BOSException, RemoteException;
    public void revoke(Context ctx, BatchContractBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void changeIsFeedBig(Context ctx, IObjectValue model) throws BOSException, EASBizException, RemoteException;
}