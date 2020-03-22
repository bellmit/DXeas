package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.ParentBreedBatchCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ParentBreedBatchController extends CoreBillBaseController
{
    public ParentBreedBatchCollection getParentBreedBatchCollection(Context ctx) throws BOSException, RemoteException;
    public ParentBreedBatchCollection getParentBreedBatchCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ParentBreedBatchCollection getParentBreedBatchCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ParentBreedBatchInfo getParentBreedBatchInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ParentBreedBatchInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, ParentBreedBatchInfo model) throws BOSException, RemoteException;
    public void updateBatchMarket(Context ctx, ParentBreedBatchInfo model) throws BOSException, RemoteException;
}