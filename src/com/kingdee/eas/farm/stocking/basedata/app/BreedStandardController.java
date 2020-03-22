package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BreedStandardController extends DataBaseController
{
    public BreedStandardInfo getBreedStandardInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BreedStandardInfo getBreedStandardInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BreedStandardInfo getBreedStandardInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BreedStandardCollection getBreedStandardCollection(Context ctx) throws BOSException, RemoteException;
    public BreedStandardCollection getBreedStandardCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BreedStandardCollection getBreedStandardCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, BreedStandardInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BreedStandardInfo model) throws BOSException, EASBizException, RemoteException;
}