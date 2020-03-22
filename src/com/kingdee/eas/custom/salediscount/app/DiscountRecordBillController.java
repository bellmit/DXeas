package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DiscountRecordBillController extends CoreBillBaseController
{
    public DiscountRecordBillCollection getDiscountRecordBillCollection(Context ctx) throws BOSException, RemoteException;
    public DiscountRecordBillCollection getDiscountRecordBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DiscountRecordBillCollection getDiscountRecordBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DiscountRecordBillInfo getDiscountRecordBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DiscountRecordBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, DiscountRecordBillInfo model) throws BOSException, RemoteException;
}