package com.kingdee.eas.custom.ccchargeback.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo;
import java.lang.String;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CcChargeBackBizBillController extends CoreBillBaseController
{
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(Context ctx) throws BOSException, RemoteException;
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CcChargeBackBizBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CcChargeBackBizBillInfo model) throws BOSException, EASBizException, RemoteException;
}