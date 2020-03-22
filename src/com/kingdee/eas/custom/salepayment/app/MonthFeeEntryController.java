package com.kingdee.eas.custom.salepayment.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.salepayment.MonthFeeEntryCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.salepayment.MonthFeeEntryInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MonthFeeEntryController extends CoreBillEntryBaseController
{
    public MonthFeeEntryInfo getMonthFeeEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MonthFeeEntryInfo getMonthFeeEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MonthFeeEntryInfo getMonthFeeEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection(Context ctx) throws BOSException, RemoteException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MonthFeeEntryCollection getMonthFeeEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}