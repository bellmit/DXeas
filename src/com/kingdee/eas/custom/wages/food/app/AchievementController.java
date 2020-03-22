package com.kingdee.eas.custom.wages.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.food.AchievementInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.custom.wages.food.AchievementCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AchievementController extends CoreBillBaseController
{
    public AchievementCollection getAchievementCollection(Context ctx) throws BOSException, RemoteException;
    public AchievementCollection getAchievementCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AchievementCollection getAchievementCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AchievementInfo getAchievementInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AchievementInfo getAchievementInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AchievementInfo getAchievementInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, AchievementInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, AchievementInfo model) throws BOSException, RemoteException;
}