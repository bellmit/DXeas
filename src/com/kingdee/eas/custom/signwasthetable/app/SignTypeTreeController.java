package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.signwasthetable.SignTypeTreeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SignTypeTreeController extends TreeBaseController
{
    public SignTypeTreeInfo getSignTypeTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SignTypeTreeInfo getSignTypeTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SignTypeTreeInfo getSignTypeTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SignTypeTreeCollection getSignTypeTreeCollection(Context ctx) throws BOSException, RemoteException;
    public SignTypeTreeCollection getSignTypeTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SignTypeTreeCollection getSignTypeTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}