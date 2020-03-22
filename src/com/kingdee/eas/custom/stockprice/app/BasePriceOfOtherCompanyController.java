package com.kingdee.eas.custom.stockprice.app;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BasePriceOfOtherCompanyController extends CoreBillBaseController
{
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(Context ctx) throws BOSException, RemoteException;
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void getAllMaterial(Context ctx, BasePriceOfOtherCompanyInfo model) throws BOSException, RemoteException;
    public void impExcel(Context ctx, BasePriceOfOtherCompanyInfo model) throws BOSException, RemoteException;
    public void expModel(Context ctx, BasePriceOfOtherCompanyInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException, RemoteException;
}