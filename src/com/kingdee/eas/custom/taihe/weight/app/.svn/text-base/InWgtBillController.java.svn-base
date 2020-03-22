package com.kingdee.eas.custom.taihe.weight.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.weight.InWgtBillCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.weight.InWgtBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface InWgtBillController extends CoreBillBaseController
{
    public InWgtBillCollection getInWgtBillCollection(Context ctx) throws BOSException, RemoteException;
    public InWgtBillCollection getInWgtBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public InWgtBillCollection getInWgtBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public InWgtBillInfo getInWgtBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public InWgtBillInfo getInWgtBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public InWgtBillInfo getInWgtBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}