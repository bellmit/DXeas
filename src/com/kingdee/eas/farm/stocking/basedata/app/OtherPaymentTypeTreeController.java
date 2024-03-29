package com.kingdee.eas.farm.stocking.basedata.app;

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
import com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OtherPaymentTypeTreeController extends TreeBaseController
{
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection(Context ctx) throws BOSException, RemoteException;
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}