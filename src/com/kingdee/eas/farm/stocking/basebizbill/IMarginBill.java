package com.kingdee.eas.farm.stocking.basebizbill;

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

public interface IMarginBill extends ICoreBillBase
{
    public MarginBillCollection getMarginBillCollection() throws BOSException;
    public MarginBillCollection getMarginBillCollection(EntityViewInfo view) throws BOSException;
    public MarginBillCollection getMarginBillCollection(String oql) throws BOSException;
    public MarginBillInfo getMarginBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginBillInfo getMarginBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginBillInfo getMarginBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MarginBillInfo model) throws BOSException;
    public void unAudit(MarginBillInfo model) throws BOSException;
}