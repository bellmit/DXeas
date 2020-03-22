package com.kingdee.eas.farm.feemanager.basedata.app;

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
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OilPriceController extends DataBaseController
{
    public OilPriceInfo getOilPriceInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OilPriceInfo getOilPriceInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OilPriceInfo getOilPriceInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public OilPriceCollection getOilPriceCollection(Context ctx) throws BOSException, RemoteException;
    public OilPriceCollection getOilPriceCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OilPriceCollection getOilPriceCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void review(Context ctx, OilPriceInfo model) throws BOSException, RemoteException;
    public void unreview(Context ctx, OilPriceInfo model) throws BOSException, RemoteException;
}