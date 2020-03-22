package com.kingdee.eas.custom.eas2temp.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.eas2temp.MMPlanEntryCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.eas2temp.MMPlanEntryInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MMPlanEntryController extends CoreBillEntryBaseController
{
    public MMPlanEntryInfo getMMPlanEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MMPlanEntryInfo getMMPlanEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MMPlanEntryInfo getMMPlanEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MMPlanEntryCollection getMMPlanEntryCollection(Context ctx) throws BOSException, RemoteException;
    public MMPlanEntryCollection getMMPlanEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MMPlanEntryCollection getMMPlanEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}