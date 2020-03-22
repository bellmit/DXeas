package com.kingdee.eas.custom.ccchargeback.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ChargeBackStdController extends DataBaseController
{
    public ChargeBackStdInfo getChargeBackStdInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ChargeBackStdInfo getChargeBackStdInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ChargeBackStdInfo getChargeBackStdInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ChargeBackStdCollection getChargeBackStdCollection(Context ctx) throws BOSException, RemoteException;
    public ChargeBackStdCollection getChargeBackStdCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ChargeBackStdCollection getChargeBackStdCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, ChargeBackStdInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ChargeBackStdInfo model) throws BOSException, EASBizException, RemoteException;
}