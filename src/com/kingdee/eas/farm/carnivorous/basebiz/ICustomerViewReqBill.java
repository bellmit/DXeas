package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICustomerViewReqBill extends ICoreBillBase
{
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection() throws BOSException;
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(EntityViewInfo view) throws BOSException;
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(String oql) throws BOSException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CustomerViewReqBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CustomerViewReqBillInfo model) throws BOSException, EASBizException;
    public void revoke(CustomerViewReqBillInfo model) throws BOSException, EASBizException;
}