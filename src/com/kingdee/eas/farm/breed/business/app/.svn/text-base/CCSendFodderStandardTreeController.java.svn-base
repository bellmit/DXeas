package com.kingdee.eas.farm.breed.business.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CCSendFodderStandardTreeController extends TreeBaseController
{
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}