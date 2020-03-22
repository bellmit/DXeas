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

public interface IMobileBillFacade extends IBizCtrl
{
    public String selectSaleOrg(String param) throws BOSException;
    public String saleOrderDetial(String param) throws BOSException;
    public String saleOrderHistory(String param) throws BOSException, EASBizException;
    public String queryCustomerByUser(String param) throws BOSException, EASBizException;
    public String queryMaterialByCustomer(String param) throws BOSException, EASBizException;
    public String addNewSaleOrder(String orderInfo) throws BOSException, EASBizException;
    public String alterOrder(String alterInfo) throws BOSException, EASBizException;
    public String queryBizType() throws BOSException, EASBizException;
}