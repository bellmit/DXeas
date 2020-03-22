package com.kingdee.eas.custom.eas2temp.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.eas2temp.DataBaseSettingCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.eas2temp.DataBaseSettingInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DataBaseSettingController extends DataBaseController
{
    public DataBaseSettingInfo getDataBaseSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DataBaseSettingInfo getDataBaseSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DataBaseSettingInfo getDataBaseSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DataBaseSettingCollection getDataBaseSettingCollection(Context ctx) throws BOSException, RemoteException;
    public DataBaseSettingCollection getDataBaseSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DataBaseSettingCollection getDataBaseSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void importMaterial(Context ctx, DataBaseSettingInfo model) throws BOSException, RemoteException;
    public void bakmaterial(Context ctx, DataBaseSettingInfo model) throws BOSException, RemoteException;
}