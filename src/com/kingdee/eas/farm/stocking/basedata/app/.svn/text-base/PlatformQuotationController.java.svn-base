package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.stocking.basedata.PlatformQuotationCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.stocking.basedata.PlatformQuotationInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PlatformQuotationController extends DataBaseController
{
    public PlatformQuotationInfo getPlatformQuotationInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PlatformQuotationInfo getPlatformQuotationInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PlatformQuotationInfo getPlatformQuotationInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PlatformQuotationCollection getPlatformQuotationCollection(Context ctx) throws BOSException, RemoteException;
    public PlatformQuotationCollection getPlatformQuotationCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PlatformQuotationCollection getPlatformQuotationCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, PlatformQuotationInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, PlatformQuotationInfo model) throws BOSException, EASBizException, RemoteException;
}