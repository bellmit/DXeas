package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.HatchBaseDataTreeCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchBaseDataTreeController extends TreeBaseController
{
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(Context ctx) throws BOSException, RemoteException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}