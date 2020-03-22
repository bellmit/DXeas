package com.kingdee.eas.farm.carnivorous.basebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginReturnBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MaiginReturnBillController extends CoreBillBaseController
{
    public MaiginReturnBillCollection getMaiginReturnBillCollection(Context ctx) throws BOSException, RemoteException;
    public MaiginReturnBillCollection getMaiginReturnBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MaiginReturnBillCollection getMaiginReturnBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, MaiginReturnBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, MaiginReturnBillInfo model) throws BOSException, EASBizException, RemoteException;
}