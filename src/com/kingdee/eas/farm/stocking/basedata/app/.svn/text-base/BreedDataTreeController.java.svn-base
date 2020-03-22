package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.basedata.BreedDataTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BreedDataTreeController extends TreeBaseController
{
    public BreedDataTreeInfo getBreedDataTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BreedDataTreeInfo getBreedDataTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BreedDataTreeInfo getBreedDataTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BreedDataTreeCollection getBreedDataTreeCollection(Context ctx) throws BOSException, RemoteException;
    public BreedDataTreeCollection getBreedDataTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BreedDataTreeCollection getBreedDataTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}