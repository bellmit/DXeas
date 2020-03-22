package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.breed.BreedBatchCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface BreedBatchController extends CoreBillBaseController
{
    public BreedBatchCollection getBreedBatchCollection(Context ctx) throws BOSException, RemoteException;
    public BreedBatchCollection getBreedBatchCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BreedBatchCollection getBreedBatchCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BreedBatchInfo getBreedBatchInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BreedBatchInfo getBreedBatchInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BreedBatchInfo getBreedBatchInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BreedBatchInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, BreedBatchInfo model) throws BOSException, RemoteException;
    public void updateBatchMarket(Context ctx, BreedBatchInfo model) throws BOSException, RemoteException;
}