package com.kingdee.eas.custom.ccchargeback;

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

public interface ICcChargeBackBizBill extends ICoreBillBase
{
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection() throws BOSException;
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(EntityViewInfo view) throws BOSException;
    public CcChargeBackBizBillCollection getCcChargeBackBizBillCollection(String oql) throws BOSException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CcChargeBackBizBillInfo getCcChargeBackBizBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CcChargeBackBizBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CcChargeBackBizBillInfo model) throws BOSException, EASBizException;
}