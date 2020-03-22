package com.kingdee.eas.custom.wages.farm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.wages.farm.HatchAssessCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.farm.HatchAssessInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface HatchAssessController extends CoreBillBaseController
{
    public HatchAssessCollection getHatchAssessCollection(Context ctx) throws BOSException, RemoteException;
    public HatchAssessCollection getHatchAssessCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public HatchAssessCollection getHatchAssessCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public HatchAssessInfo getHatchAssessInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public HatchAssessInfo getHatchAssessInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public HatchAssessInfo getHatchAssessInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, HatchAssessInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, HatchAssessInfo model) throws BOSException, RemoteException;
}