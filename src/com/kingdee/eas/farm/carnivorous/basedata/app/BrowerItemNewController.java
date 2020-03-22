package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BrowerItemNewController extends DataBaseController
{
    public BrowerItemNewInfo getBrowerItemNewInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BrowerItemNewInfo getBrowerItemNewInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BrowerItemNewInfo getBrowerItemNewInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BrowerItemNewCollection getBrowerItemNewCollection(Context ctx) throws BOSException, RemoteException;
    public BrowerItemNewCollection getBrowerItemNewCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BrowerItemNewCollection getBrowerItemNewCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, BrowerItemNewInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BrowerItemNewInfo model) throws BOSException, EASBizException, RemoteException;
}