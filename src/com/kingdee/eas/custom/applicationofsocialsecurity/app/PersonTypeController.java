package com.kingdee.eas.custom.applicationofsocialsecurity.app;

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
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PersonTypeController extends DataBaseController
{
    public PersonTypeInfo getPersonTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PersonTypeInfo getPersonTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PersonTypeInfo getPersonTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PersonTypeCollection getPersonTypeCollection(Context ctx) throws BOSException, RemoteException;
    public PersonTypeCollection getPersonTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PersonTypeCollection getPersonTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, PersonTypeInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, PersonTypeInfo model) throws BOSException, RemoteException;
}