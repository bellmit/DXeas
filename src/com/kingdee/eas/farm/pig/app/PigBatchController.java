package com.kingdee.eas.farm.pig.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.pig.PigBatchInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.PigBatchCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PigBatchController extends CoreBillBaseController
{
    public PigBatchCollection getPigBatchCollection(Context ctx) throws BOSException, RemoteException;
    public PigBatchCollection getPigBatchCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PigBatchCollection getPigBatchCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public PigBatchInfo getPigBatchInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PigBatchInfo getPigBatchInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PigBatchInfo getPigBatchInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, PigBatchInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, PigBatchInfo model) throws BOSException, RemoteException;
    public void updateBatchMarket(Context ctx, PigBatchInfo model) throws BOSException, RemoteException;
}