package com.kingdee.eas.farm.stocking.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.hatch.SecondAllotInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.hatch.SecondAllotCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SecondAllotController extends DataBaseController
{
    public SecondAllotInfo getSecondAllotInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SecondAllotInfo getSecondAllotInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SecondAllotInfo getSecondAllotInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SecondAllotCollection getSecondAllotCollection(Context ctx) throws BOSException, RemoteException;
    public SecondAllotCollection getSecondAllotCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SecondAllotCollection getSecondAllotCollection(Context ctx, String oql) throws BOSException, RemoteException;
}