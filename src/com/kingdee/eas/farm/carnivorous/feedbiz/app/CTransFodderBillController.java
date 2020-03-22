package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CTransFodderBillController extends CoreBillBaseController
{
    public CTransFodderBillCollection getCTransFodderBillCollection(Context ctx) throws BOSException, RemoteException;
    public CTransFodderBillCollection getCTransFodderBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CTransFodderBillCollection getCTransFodderBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CTransFodderBillInfo getCTransFodderBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CTransFodderBillInfo getCTransFodderBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CTransFodderBillInfo getCTransFodderBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CTransFodderBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CTransFodderBillInfo model) throws BOSException, EASBizException, RemoteException;
}