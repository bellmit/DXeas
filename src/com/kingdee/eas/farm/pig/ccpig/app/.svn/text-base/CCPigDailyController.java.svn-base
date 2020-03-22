package com.kingdee.eas.farm.pig.ccpig.app;

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
import com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.pig.ccpig.CCPigDailyCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CCPigDailyController extends CoreBillBaseController
{
    public CCPigDailyCollection getCCPigDailyCollection(Context ctx) throws BOSException, RemoteException;
    public CCPigDailyCollection getCCPigDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CCPigDailyCollection getCCPigDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CCPigDailyInfo getCCPigDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CCPigDailyInfo getCCPigDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CCPigDailyInfo getCCPigDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CCPigDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, CCPigDailyInfo model) throws BOSException, RemoteException;
}