package com.kingdee.eas.custom.applicationofsocialsecurity.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ApplicationOfSocialSecurityController extends CoreBillBaseController
{
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(Context ctx) throws BOSException, RemoteException;
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException, RemoteException;
    public void setSIStatus(Context ctx, ApplicationOfSocialSecurityInfo model) throws BOSException, RemoteException;
}