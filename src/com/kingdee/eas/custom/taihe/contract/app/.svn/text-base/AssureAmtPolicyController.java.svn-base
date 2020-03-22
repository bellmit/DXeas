package com.kingdee.eas.custom.taihe.contract.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AssureAmtPolicyController extends DataBaseController
{
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(Context ctx) throws BOSException, RemoteException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, AssureAmtPolicyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, AssureAmtPolicyInfo model) throws BOSException, RemoteException;
}