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
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AssessmentMeasureController extends CoreBillBaseController
{
    public AssessmentMeasureCollection getAssessmentMeasureCollection(Context ctx) throws BOSException, RemoteException;
    public AssessmentMeasureCollection getAssessmentMeasureCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AssessmentMeasureCollection getAssessmentMeasureCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, AssessmentMeasureInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, AssessmentMeasureInfo model) throws BOSException, RemoteException;
}