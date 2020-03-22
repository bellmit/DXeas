package com.kingdee.eas.custom.taihe.sale.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.sale.ComplainedTypeTreeCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ComplainedTypeTreeController extends TreeBaseController
{
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection(Context ctx) throws BOSException, RemoteException;
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}