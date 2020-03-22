package com.kingdee.eas.custom.znck.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.znck.MaterialLedRelInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.znck.MaterialLedRelCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
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

public interface MaterialLedRelController extends CoreBillBaseController
{
    public MaterialLedRelCollection getMaterialLedRelCollection(Context ctx) throws BOSException, RemoteException;
    public MaterialLedRelCollection getMaterialLedRelCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MaterialLedRelCollection getMaterialLedRelCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public MaterialLedRelInfo getMaterialLedRelInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MaterialLedRelInfo getMaterialLedRelInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MaterialLedRelInfo getMaterialLedRelInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}