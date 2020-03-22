package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

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
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKPECostbillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKPECostbillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CKPECostbillController extends CoreBillBaseController
{
    public CKPECostbillCollection getCKPECostbillCollection(Context ctx) throws BOSException, RemoteException;
    public CKPECostbillCollection getCKPECostbillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CKPECostbillCollection getCKPECostbillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CKPECostbillInfo getCKPECostbillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CKPECostbillInfo getCKPECostbillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CKPECostbillInfo getCKPECostbillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}