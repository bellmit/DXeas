package com.kingdee.eas.farm.carnivorous.assistbiz;

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

public interface ICKFreightBill extends ICoreBillBase
{
    public CKFreightBillCollection getCKFreightBillCollection() throws BOSException;
    public CKFreightBillCollection getCKFreightBillCollection(EntityViewInfo view) throws BOSException;
    public CKFreightBillCollection getCKFreightBillCollection(String oql) throws BOSException;
    public CKFreightBillInfo getCKFreightBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKFreightBillInfo getCKFreightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKFreightBillInfo getCKFreightBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CKFreightBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CKFreightBillInfo model) throws BOSException, EASBizException;
    public void calFreight(CKFreightBillInfo model) throws BOSException, EASBizException;
}