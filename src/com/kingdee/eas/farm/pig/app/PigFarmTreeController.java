package com.kingdee.eas.farm.pig.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.pig.PigFarmTreeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.pig.PigFarmTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PigFarmTreeController extends TreeBaseController
{
    public PigFarmTreeInfo getPigFarmTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PigFarmTreeInfo getPigFarmTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PigFarmTreeInfo getPigFarmTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PigFarmTreeCollection getPigFarmTreeCollection(Context ctx) throws BOSException, RemoteException;
    public PigFarmTreeCollection getPigFarmTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PigFarmTreeCollection getPigFarmTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}