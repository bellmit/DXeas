package com.kingdee.eas.farm.carnivorous.basebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplCollection;
import java.lang.String;
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

public interface FarmerQualicationApplController extends CoreBillBaseController
{
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(Context ctx) throws BOSException, RemoteException;
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmerQualicationApplCollection getFarmerQualicationApplCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmerQualicationApplInfo getFarmerQualicationApplInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FarmerQualicationApplInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, FarmerQualicationApplInfo model) throws BOSException, EASBizException, RemoteException;
    public void isTemplate(Context ctx, FarmerQualicationApplInfo model) throws BOSException, RemoteException;
    public void isCheckItemEntry(Context ctx, FarmerQualicationApplInfo model) throws BOSException, RemoteException;
    public void viewGuaranteeBill(Context ctx, FarmerQualicationApplInfo model) throws BOSException, EASBizException, RemoteException;
}