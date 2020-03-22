package com.kingdee.eas.custom.salepayment.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MaterialStandardCostController extends DataBaseController
{
    public MaterialStandardCostInfo getMaterialStandardCostInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MaterialStandardCostInfo getMaterialStandardCostInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MaterialStandardCostInfo getMaterialStandardCostInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection(Context ctx) throws BOSException, RemoteException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, MaterialStandardCostInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, MaterialStandardCostInfo model) throws BOSException, RemoteException;
}