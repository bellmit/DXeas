package com.kingdee.eas.custom.test.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.test.SignwasthetableInfo;
import com.kingdee.eas.custom.test.SignwasthetableCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SignwasthetableController extends CoreBillBaseController
{
    public SignwasthetableCollection getSignwasthetableCollection(Context ctx) throws BOSException, RemoteException;
    public SignwasthetableCollection getSignwasthetableCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SignwasthetableCollection getSignwasthetableCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SignwasthetableInfo getSignwasthetableInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SignwasthetableInfo getSignwasthetableInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SignwasthetableInfo getSignwasthetableInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void check(Context ctx, SignwasthetableInfo model) throws BOSException, RemoteException;
    public void deleteLine(Context ctx, SignwasthetableInfo model) throws BOSException, RemoteException;
    public void listener(Context ctx, SignwasthetableInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, SignwasthetableInfo model) throws BOSException, RemoteException;
    public void btnRefresh(Context ctx, SignwasthetableInfo model) throws BOSException, RemoteException;
}