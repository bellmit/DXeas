package com.kingdee.eas.bdm.bdapply.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.bdm.bdapply.MaterialInfoReqCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MaterialInfoReqController extends CoreBillBaseController
{
    public MaterialInfoReqCollection getMaterialInfoReqCollection(Context ctx) throws BOSException, RemoteException;
    public MaterialInfoReqCollection getMaterialInfoReqCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MaterialInfoReqCollection getMaterialInfoReqCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void materialInfoAudit(Context ctx, MaterialInfoReqInfo model) throws BOSException, RemoteException;
    public void basenotby(Context ctx, MaterialInfoReqInfo model) throws BOSException, RemoteException;
    public void allAudit(Context ctx, MaterialInfoReqInfo model) throws BOSException, RemoteException;
}