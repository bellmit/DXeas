package com.kingdee.eas.farm.breed.business.app;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CCBreedPlanController extends CoreBillBaseController
{
    public CCBreedPlanCollection getCCBreedPlanCollection(Context ctx) throws BOSException, RemoteException;
    public CCBreedPlanCollection getCCBreedPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CCBreedPlanCollection getCCBreedPlanCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CCBreedPlanInfo getCCBreedPlanInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CCBreedPlanInfo getCCBreedPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CCBreedPlanInfo getCCBreedPlanInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CCBreedPlanInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, CCBreedPlanInfo model) throws BOSException, RemoteException;
    public void getCCBreedPlan(Context ctx, CCBreedPlanInfo model) throws BOSException, RemoteException;
}