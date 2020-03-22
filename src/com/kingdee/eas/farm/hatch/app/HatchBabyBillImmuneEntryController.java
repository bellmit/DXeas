package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchBabyBillImmuneEntryController extends CoreBillEntryBaseController
{
    public boolean exists(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public boolean exists(Context ctx, FilterInfo filter) throws BOSException, EASBizException, RemoteException;
    public boolean exists(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillImmuneEntryInfo getHatchBabyBillImmuneEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillImmuneEntryInfo getHatchBabyBillImmuneEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillImmuneEntryInfo getHatchBabyBillImmuneEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public IObjectPK addnew(Context ctx, HatchBabyBillImmuneEntryInfo model) throws BOSException, EASBizException, RemoteException;
    public void addnew(Context ctx, IObjectPK pk, HatchBabyBillImmuneEntryInfo model) throws BOSException, EASBizException, RemoteException;
    public void update(Context ctx, IObjectPK pk, HatchBabyBillImmuneEntryInfo model) throws BOSException, EASBizException, RemoteException;
    public void updatePartial(Context ctx, HatchBabyBillImmuneEntryInfo model, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public void updateBigObject(Context ctx, IObjectPK pk, HatchBabyBillImmuneEntryInfo model) throws BOSException, RemoteException;
    public void delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public IObjectPK[] getPKList(Context ctx) throws BOSException, EASBizException, RemoteException;
    public IObjectPK[] getPKList(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public IObjectPK[] getPKList(Context ctx, FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException, RemoteException;
    public HatchBabyBillImmuneEntryCollection getHatchBabyBillImmuneEntryCollection(Context ctx) throws BOSException, RemoteException;
    public HatchBabyBillImmuneEntryCollection getHatchBabyBillImmuneEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchBabyBillImmuneEntryCollection getHatchBabyBillImmuneEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public IObjectPK[] delete(Context ctx, FilterInfo filter) throws BOSException, EASBizException, RemoteException;
    public IObjectPK[] delete(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void delete(Context ctx, IObjectPK[] arrayPK) throws BOSException, EASBizException, RemoteException;
}