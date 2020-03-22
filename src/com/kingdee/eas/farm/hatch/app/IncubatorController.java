package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.hatch.IncubatorInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.hatch.IncubatorCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface IncubatorController extends DataBaseController
{
    public IncubatorInfo getIncubatorInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public IncubatorInfo getIncubatorInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public IncubatorInfo getIncubatorInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public IncubatorCollection getIncubatorCollection(Context ctx) throws BOSException, RemoteException;
    public IncubatorCollection getIncubatorCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public IncubatorCollection getIncubatorCollection(Context ctx, String oql) throws BOSException, RemoteException;
}