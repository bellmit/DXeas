package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.OverPayInfo;
import com.kingdee.eas.custom.signwasthetable.OverPayCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OverPayController extends CoreBillBaseController
{
    public OverPayCollection getOverPayCollection(Context ctx) throws BOSException, RemoteException;
    public OverPayCollection getOverPayCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OverPayCollection getOverPayCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public OverPayInfo getOverPayInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OverPayInfo getOverPayInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OverPayInfo getOverPayInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void viewSrcBill(Context ctx, OverPayInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, OverPayInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, OverPayInfo model) throws BOSException, RemoteException;
}