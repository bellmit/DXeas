package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillEntryInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillEntryCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DrugApplyBillEntryController extends CoreBillEntryBaseController
{
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DrugApplyBillEntryInfo getDrugApplyBillEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(Context ctx) throws BOSException, RemoteException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DrugApplyBillEntryCollection getDrugApplyBillEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}