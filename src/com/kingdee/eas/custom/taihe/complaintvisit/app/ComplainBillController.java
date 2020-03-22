package com.kingdee.eas.custom.taihe.complaintvisit.app;

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
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillCollection;
import com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ComplainBillController extends WlhlBillBaseController
{
    public ComplainBillCollection getComplainBillCollection(Context ctx) throws BOSException, RemoteException;
    public ComplainBillCollection getComplainBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ComplainBillCollection getComplainBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ComplainBillInfo getComplainBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ComplainBillInfo getComplainBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ComplainBillInfo getComplainBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}