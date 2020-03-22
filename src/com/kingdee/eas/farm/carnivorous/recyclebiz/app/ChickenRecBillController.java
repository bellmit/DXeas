package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ChickenRecBillController extends CoreBillBaseController
{
    public ChickenRecBillCollection getChickenRecBillCollection(Context ctx) throws BOSException, RemoteException;
    public ChickenRecBillCollection getChickenRecBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ChickenRecBillCollection getChickenRecBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ChickenRecBillInfo getChickenRecBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ChickenRecBillInfo getChickenRecBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ChickenRecBillInfo getChickenRecBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ChickenRecBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ChickenRecBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void manageCarSeq(Context ctx, ChickenRecBillInfo model, Map map) throws BOSException, EASBizException, RemoteException;
}