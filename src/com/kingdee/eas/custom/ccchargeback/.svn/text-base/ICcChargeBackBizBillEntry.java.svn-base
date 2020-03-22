package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICcChargeBackBizBillEntry extends ICoreBillEntryBase
{
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CcChargeBackBizBillEntryInfo getCcChargeBackBizBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection() throws BOSException;
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CcChargeBackBizBillEntryCollection getCcChargeBackBizBillEntryCollection(String oql) throws BOSException;
}