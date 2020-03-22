package com.kingdee.eas.farm.dayratecost.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ArAmountOffsetDetailBillController extends CoreBillBaseController
{
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(Context ctx) throws BOSException, RemoteException;
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException, RemoteException;
}