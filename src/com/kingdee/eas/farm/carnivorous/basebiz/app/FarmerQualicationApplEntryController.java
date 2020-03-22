package com.kingdee.eas.farm.carnivorous.basebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryCollection;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmerQualicationApplEntryController extends CoreBillEntryBaseController
{
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(Context ctx) throws BOSException, RemoteException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}