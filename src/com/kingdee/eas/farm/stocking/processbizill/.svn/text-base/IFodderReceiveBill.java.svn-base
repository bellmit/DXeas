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

public interface IFodderReceiveBill extends ICoreBillBase
{
    public FodderReceiveBillCollection getFodderReceiveBillCollection() throws BOSException;
    public FodderReceiveBillCollection getFodderReceiveBillCollection(EntityViewInfo view) throws BOSException;
    public FodderReceiveBillCollection getFodderReceiveBillCollection(String oql) throws BOSException;
    public FodderReceiveBillInfo getFodderReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FodderReceiveBillInfo getFodderReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FodderReceiveBillInfo getFodderReceiveBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FodderReceiveBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FodderReceiveBillInfo model) throws BOSException, EASBizException;
    public void chkVoucherAll(FodderReceiveBillInfo model) throws BOSException;
    public void chkVoucherFlag(FodderReceiveBillInfo model) throws BOSException;
}