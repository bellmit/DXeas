package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryInfo;
import java.lang.String;
import com.kingdee.eas.farm.stocking.processbizill.FarmerSettlementOfInterestEditUIEntryCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmerSettlementOfInterestEditUIEntryController extends CoreBillEntryBaseController
{
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmerSettlementOfInterestEditUIEntryInfo getFarmerSettlementOfInterestEditUIEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection(Context ctx) throws BOSException, RemoteException;
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmerSettlementOfInterestEditUIEntryCollection getFarmerSettlementOfInterestEditUIEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}