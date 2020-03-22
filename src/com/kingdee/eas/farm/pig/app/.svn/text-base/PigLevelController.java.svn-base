package com.kingdee.eas.farm.pig.app;

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
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.PigLevelInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.pig.PigLevelCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PigLevelController extends DataBaseController
{
    public PigLevelInfo getPigLevelInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PigLevelInfo getPigLevelInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PigLevelInfo getPigLevelInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PigLevelCollection getPigLevelCollection(Context ctx) throws BOSException, RemoteException;
    public PigLevelCollection getPigLevelCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PigLevelCollection getPigLevelCollection(Context ctx, String oql) throws BOSException, RemoteException;
}