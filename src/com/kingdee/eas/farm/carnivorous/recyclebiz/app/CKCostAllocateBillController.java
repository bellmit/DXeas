package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKCostAllocateBillController extends CoreBillBaseController
{
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(Context ctx) throws BOSException, RemoteException;
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void execAllocate(Context ctx, CKCostAllocateBillInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, CKCostAllocateBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CKCostAllocateBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void costAmt(Context ctx, CKCostAllocateBillInfo model) throws BOSException, EASBizException, RemoteException;
}