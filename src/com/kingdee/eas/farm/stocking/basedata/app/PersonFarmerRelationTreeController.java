package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationTreeCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PersonFarmerRelationTreeController extends TreeBaseController
{
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection(Context ctx) throws BOSException, RemoteException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}