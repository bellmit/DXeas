package com.kingdee.eas.custom.szcount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.szcount.SzCountPositionSetTreeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SzCountPositionSetTreeController extends TreeBaseController
{
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(Context ctx) throws BOSException, RemoteException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}