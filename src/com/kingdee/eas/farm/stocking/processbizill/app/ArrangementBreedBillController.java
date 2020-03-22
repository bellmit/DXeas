package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.processbizill.ArrangementBreedBillInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.processbizill.ArrangementBreedBillCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ArrangementBreedBillController extends CoreBillBaseController
{
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(Context ctx) throws BOSException, RemoteException;
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ArrangementBreedBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, ArrangementBreedBillInfo model) throws BOSException, RemoteException;
}