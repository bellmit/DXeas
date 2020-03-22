package com.kingdee.eas.custom.wages.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wages.PersonTaxCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.PersonTaxInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PersonTaxController extends DataBaseController
{
    public PersonTaxInfo getPersonTaxInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PersonTaxInfo getPersonTaxInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PersonTaxInfo getPersonTaxInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PersonTaxCollection getPersonTaxCollection(Context ctx) throws BOSException, RemoteException;
    public PersonTaxCollection getPersonTaxCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PersonTaxCollection getPersonTaxCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void approve(Context ctx, PersonTaxInfo model) throws BOSException, RemoteException;
    public void unApprove(Context ctx, PersonTaxInfo model) throws BOSException, RemoteException;
}