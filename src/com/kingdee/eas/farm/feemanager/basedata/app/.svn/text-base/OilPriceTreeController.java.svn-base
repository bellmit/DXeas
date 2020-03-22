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
import com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OilPriceTreeController extends TreeBaseController
{
    public OilPriceTreeInfo getOilPriceTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OilPriceTreeInfo getOilPriceTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OilPriceTreeInfo getOilPriceTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public OilPriceTreeCollection getOilPriceTreeCollection(Context ctx) throws BOSException, RemoteException;
    public OilPriceTreeCollection getOilPriceTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OilPriceTreeCollection getOilPriceTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}