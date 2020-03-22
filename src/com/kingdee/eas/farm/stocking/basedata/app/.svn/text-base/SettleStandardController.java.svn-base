package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.stocking.basedata.SettleStandardInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.basedata.SettleStandardCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettleStandardController extends DataBaseController
{
    public SettleStandardInfo getSettleStandardInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettleStandardInfo getSettleStandardInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettleStandardInfo getSettleStandardInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SettleStandardCollection getSettleStandardCollection(Context ctx) throws BOSException, RemoteException;
    public SettleStandardCollection getSettleStandardCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettleStandardCollection getSettleStandardCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, SettleStandardInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SettleStandardInfo model) throws BOSException, EASBizException, RemoteException;
}