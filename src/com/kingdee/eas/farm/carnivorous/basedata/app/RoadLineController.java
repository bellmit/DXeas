package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basedata.RoadLineCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface RoadLineController extends DataBaseController
{
    public RoadLineInfo getRoadLineInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public RoadLineInfo getRoadLineInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public RoadLineInfo getRoadLineInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public RoadLineCollection getRoadLineCollection(Context ctx) throws BOSException, RemoteException;
    public RoadLineCollection getRoadLineCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public RoadLineCollection getRoadLineCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, RoadLineInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, RoadLineInfo model) throws BOSException, EASBizException, RemoteException;
}