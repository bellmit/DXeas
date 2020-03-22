package com.kingdee.eas.farm.carnivorous.assistbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKGrowthFreightBillController extends DataBaseController
{
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(Context ctx) throws BOSException, RemoteException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, CKGrowthFreightBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CKGrowthFreightBillInfo model) throws BOSException, EASBizException, RemoteException;
}