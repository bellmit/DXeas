package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.signwasthetable.CmChangeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.signwasthetable.CmChangeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CmChangeController extends CoreBillBaseController
{
    public CmChangeCollection getCmChangeCollection(Context ctx) throws BOSException, RemoteException;
    public CmChangeCollection getCmChangeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CmChangeCollection getCmChangeCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CmChangeInfo getCmChangeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CmChangeInfo getCmChangeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CmChangeInfo getCmChangeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}