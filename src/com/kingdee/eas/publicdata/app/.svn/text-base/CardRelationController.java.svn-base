package com.kingdee.eas.publicdata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.publicdata.CardRelationInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.publicdata.CardRelationCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CardRelationController extends DataBaseController
{
    public CardRelationInfo getCardRelationInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CardRelationInfo getCardRelationInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CardRelationInfo getCardRelationInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CardRelationCollection getCardRelationCollection(Context ctx) throws BOSException, RemoteException;
    public CardRelationCollection getCardRelationCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CardRelationCollection getCardRelationCollection(Context ctx, String oql) throws BOSException, RemoteException;
}