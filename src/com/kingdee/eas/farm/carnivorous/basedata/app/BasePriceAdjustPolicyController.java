package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BasePriceAdjustPolicyController extends DataBaseController
{
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection(Context ctx) throws BOSException, RemoteException;
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, BasePriceAdjustPolicyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, BasePriceAdjustPolicyInfo model) throws BOSException, RemoteException;
}