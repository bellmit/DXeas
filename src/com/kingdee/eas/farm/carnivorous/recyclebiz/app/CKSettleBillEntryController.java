package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKSettleBillEntryController extends CoreBillEntryBaseController
{
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection(Context ctx) throws BOSException, RemoteException;
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}