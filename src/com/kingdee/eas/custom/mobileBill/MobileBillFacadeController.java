package com.kingdee.eas.custom.mobileBill;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MobileBillFacadeController extends BizController
{
    public String selectSaleOrg(Context ctx, String param) throws BOSException, RemoteException;
    public String saleOrderDetial(Context ctx, String param) throws BOSException, RemoteException;
    public String saleOrderHistory(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String queryCustomerByUser(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String queryMaterialByCustomer(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String addNewSaleOrder(Context ctx, String orderInfo) throws BOSException, EASBizException, RemoteException;
    public String alterOrder(Context ctx, String alterInfo) throws BOSException, EASBizException, RemoteException;
    public String queryBizType(Context ctx) throws BOSException, EASBizException, RemoteException;
}