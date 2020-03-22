package com.kingdee.eas.custom.eas2temp.app;

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
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BillDeafultSettingTreeController extends TreeBaseController
{
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(Context ctx) throws BOSException, RemoteException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}