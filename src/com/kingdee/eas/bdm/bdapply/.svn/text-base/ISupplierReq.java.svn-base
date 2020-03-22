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

public interface ISupplierReq extends ICoreBillBase
{
    public SupplierReqCollection getSupplierReqCollection() throws BOSException;
    public SupplierReqCollection getSupplierReqCollection(EntityViewInfo view) throws BOSException;
    public SupplierReqCollection getSupplierReqCollection(String oql) throws BOSException;
    public SupplierReqInfo getSupplierReqInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SupplierReqInfo getSupplierReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SupplierReqInfo getSupplierReqInfo(String oql) throws BOSException, EASBizException;
    public void supplierAudit(SupplierReqInfo model) throws BOSException;
    public void basenotby(SupplierReqInfo model) throws BOSException;
    public void allAudit(SupplierReqInfo model) throws BOSException;
}