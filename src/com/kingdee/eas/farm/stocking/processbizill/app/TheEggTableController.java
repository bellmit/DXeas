package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.processbizill.TheEggTableCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TheEggTableController extends CoreBillBaseController
{
    public TheEggTableCollection getTheEggTableCollection(Context ctx) throws BOSException, RemoteException;
    public TheEggTableCollection getTheEggTableCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TheEggTableCollection getTheEggTableCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public TheEggTableInfo getTheEggTableInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TheEggTableInfo getTheEggTableInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TheEggTableInfo getTheEggTableInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, TheEggTableInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, TheEggTableInfo model) throws BOSException, EASBizException, RemoteException;
    public void showPriceCol(Context ctx, TheEggTableInfo model) throws BOSException, RemoteException;
    public void viewAllBill(Context ctx, TheEggTableInfo model) throws BOSException, RemoteException;
}