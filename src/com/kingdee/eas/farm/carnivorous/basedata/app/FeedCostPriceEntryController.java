package com.kingdee.eas.farm.carnivorous.basedata.app;

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
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeedCostPriceEntryController extends CoreBillEntryBaseController
{
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(Context ctx) throws BOSException, RemoteException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}