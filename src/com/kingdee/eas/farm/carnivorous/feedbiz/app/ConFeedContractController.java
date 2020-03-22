package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ConFeedContractController extends CoreBillBaseController
{
    public ConFeedContractCollection getConFeedContractCollection(Context ctx) throws BOSException, RemoteException;
    public ConFeedContractCollection getConFeedContractCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ConFeedContractCollection getConFeedContractCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ConFeedContractInfo getConFeedContractInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ConFeedContractInfo getConFeedContractInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ConFeedContractInfo getConFeedContractInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ConFeedContractInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ConFeedContractInfo model) throws BOSException, EASBizException, RemoteException;
    public void updateFeed(Context ctx, ConFeedContractInfo model) throws BOSException, EASBizException, RemoteException;
}