package com.kingdee.eas.farm.feemanager.basedata.app;

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
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.feemanager.basedata.SettlementCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.feemanager.basedata.SettlementInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettlementController extends DataBaseController
{
    public SettlementInfo getSettlementInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettlementInfo getSettlementInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettlementInfo getSettlementInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SettlementCollection getSettlementCollection(Context ctx) throws BOSException, RemoteException;
    public SettlementCollection getSettlementCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettlementCollection getSettlementCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void review(Context ctx, SettlementInfo model) throws BOSException, RemoteException;
    public void unreview(Context ctx, SettlementInfo model) throws BOSException, RemoteException;
}