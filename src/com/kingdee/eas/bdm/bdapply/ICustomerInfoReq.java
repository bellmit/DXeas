package com.kingdee.eas.bdm.bdapply;

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

public interface ICustomerInfoReq extends ICoreBillBase
{
    public CustomerInfoReqCollection getCustomerInfoReqCollection() throws BOSException;
    public CustomerInfoReqCollection getCustomerInfoReqCollection(EntityViewInfo view) throws BOSException;
    public CustomerInfoReqCollection getCustomerInfoReqCollection(String oql) throws BOSException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(String oql) throws BOSException, EASBizException;
    public void customerInfoReqAudit(CustomerInfoReqInfo model) throws BOSException;
    public void notby(CustomerInfoReqInfo model) throws BOSException;
    public void allAudit(CustomerInfoReqInfo model) throws BOSException;
}