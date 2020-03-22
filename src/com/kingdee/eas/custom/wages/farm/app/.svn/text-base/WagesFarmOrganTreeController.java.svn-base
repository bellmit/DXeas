package com.kingdee.eas.custom.wages.farm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WagesFarmOrganTreeController extends TreeBaseController
{
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(Context ctx) throws BOSException, RemoteException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}