package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IFodderApplyBill extends ICoreBillBase
{
    public FodderApplyBillCollection getFodderApplyBillCollection() throws BOSException;
    public FodderApplyBillCollection getFodderApplyBillCollection(EntityViewInfo view) throws BOSException;
    public FodderApplyBillCollection getFodderApplyBillCollection(String oql) throws BOSException;
    public FodderApplyBillInfo getFodderApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FodderApplyBillInfo getFodderApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FodderApplyBillInfo getFodderApplyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FodderApplyBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FodderApplyBillInfo model) throws BOSException, EASBizException;
}