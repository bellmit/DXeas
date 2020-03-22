package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.salediscount.DiscountCompanyTreeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DiscountCompanyTreeController extends TreeBaseController
{
    public DiscountCompanyTreeInfo getDiscountCompanyTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DiscountCompanyTreeInfo getDiscountCompanyTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DiscountCompanyTreeInfo getDiscountCompanyTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DiscountCompanyTreeCollection getDiscountCompanyTreeCollection(Context ctx) throws BOSException, RemoteException;
    public DiscountCompanyTreeCollection getDiscountCompanyTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DiscountCompanyTreeCollection getDiscountCompanyTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}