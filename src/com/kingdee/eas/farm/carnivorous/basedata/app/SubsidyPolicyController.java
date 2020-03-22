package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo;
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

public interface SubsidyPolicyController extends DataBaseController
{
    public SubsidyPolicyInfo getSubsidyPolicyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SubsidyPolicyInfo getSubsidyPolicyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SubsidyPolicyInfo getSubsidyPolicyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection(Context ctx) throws BOSException, RemoteException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SubsidyPolicyCollection getSubsidyPolicyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, SubsidyPolicyInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SubsidyPolicyInfo model) throws BOSException, EASBizException, RemoteException;
}