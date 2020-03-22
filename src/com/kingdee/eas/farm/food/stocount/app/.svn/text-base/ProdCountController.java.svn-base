package com.kingdee.eas.farm.food.stocount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.food.stocount.ProdCountCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.food.stocount.ProdCountInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ProdCountController extends CoreBillBaseController
{
    public ProdCountCollection getProdCountCollection(Context ctx) throws BOSException, RemoteException;
    public ProdCountCollection getProdCountCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ProdCountCollection getProdCountCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ProdCountInfo getProdCountInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ProdCountInfo getProdCountInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ProdCountInfo getProdCountInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ProdCountInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, ProdCountInfo model) throws BOSException, RemoteException;
}