package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICustomerSaleTarget extends IDataBase
{
    public CustomerSaleTargetInfo getCustomerSaleTargetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerSaleTargetInfo getCustomerSaleTargetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerSaleTargetInfo getCustomerSaleTargetInfo(String oql) throws BOSException, EASBizException;
    public CustomerSaleTargetCollection getCustomerSaleTargetCollection() throws BOSException;
    public CustomerSaleTargetCollection getCustomerSaleTargetCollection(EntityViewInfo view) throws BOSException;
    public CustomerSaleTargetCollection getCustomerSaleTargetCollection(String oql) throws BOSException;
    public void audit(CustomerSaleTargetInfo model) throws BOSException;
    public void unAudit(CustomerSaleTargetInfo model) throws BOSException;
}