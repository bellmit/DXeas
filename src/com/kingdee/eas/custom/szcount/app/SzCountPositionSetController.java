package com.kingdee.eas.custom.szcount.app;

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
import com.kingdee.eas.custom.szcount.SzCountPositionSetInfo;
import com.kingdee.eas.custom.szcount.SzCountPositionSetCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SzCountPositionSetController extends DataBaseController
{
    public SzCountPositionSetInfo getSzCountPositionSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetInfo getSzCountPositionSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetInfo getSzCountPositionSetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection(Context ctx) throws BOSException, RemoteException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void importforEx(Context ctx, SzCountPositionSetInfo model) throws BOSException, RemoteException;
}