package com.kingdee.eas.farm.carnivorous.basedata.app;

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
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CarviousFeedComMeatController extends DataBaseController
{
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(Context ctx) throws BOSException, RemoteException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, CarviousFeedComMeatInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CarviousFeedComMeatInfo model) throws BOSException, EASBizException, RemoteException;
}