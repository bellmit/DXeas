package com.kingdee.eas.publicdata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.publicdata.DatabaseSettingTreeCollection;
import com.kingdee.eas.publicdata.DatabaseSettingTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DatabaseSettingTreeController extends TreeBaseController
{
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(Context ctx) throws BOSException, RemoteException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}