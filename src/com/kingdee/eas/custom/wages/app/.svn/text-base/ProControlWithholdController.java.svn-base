package com.kingdee.eas.custom.wages.app;

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
import com.kingdee.eas.custom.wages.ProControlWithholdCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wages.ProControlWithholdInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProControlWithholdController extends CoreBillBaseController
{
    public ProControlWithholdCollection getProControlWithholdCollection(Context ctx) throws BOSException, RemoteException;
    public ProControlWithholdCollection getProControlWithholdCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProControlWithholdCollection getProControlWithholdCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ProControlWithholdInfo getProControlWithholdInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProControlWithholdInfo getProControlWithholdInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProControlWithholdInfo getProControlWithholdInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ProControlWithholdInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, ProControlWithholdInfo model) throws BOSException, RemoteException;
}