package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.CompanyOwnBreedSetCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.breed.CompanyOwnBreedSetInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CompanyOwnBreedSetController extends DataBaseController
{
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CompanyOwnBreedSetInfo getCompanyOwnBreedSetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection(Context ctx) throws BOSException, RemoteException;
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CompanyOwnBreedSetCollection getCompanyOwnBreedSetCollection(Context ctx, String oql) throws BOSException, RemoteException;
}