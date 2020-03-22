package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo;
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

public interface PersonFarmerRangeTreeController extends TreeBaseController
{
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection(Context ctx) throws BOSException, RemoteException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}