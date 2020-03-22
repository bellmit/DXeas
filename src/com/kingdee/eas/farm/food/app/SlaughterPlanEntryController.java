package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.SlaughterPlanEntryCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.food.SlaughterPlanEntryInfo;
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

public interface SlaughterPlanEntryController extends CoreBillEntryBaseController
{
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection(Context ctx) throws BOSException, RemoteException;
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}