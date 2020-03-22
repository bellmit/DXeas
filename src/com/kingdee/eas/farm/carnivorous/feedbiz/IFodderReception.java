package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IFodderReception extends ICoreBillBase
{
    public FodderReceptionCollection getFodderReceptionCollection() throws BOSException;
    public FodderReceptionCollection getFodderReceptionCollection(EntityViewInfo view) throws BOSException;
    public FodderReceptionCollection getFodderReceptionCollection(String oql) throws BOSException;
    public FodderReceptionInfo getFodderReceptionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FodderReceptionInfo getFodderReceptionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FodderReceptionInfo getFodderReceptionInfo(String oql) throws BOSException, EASBizException;
    public void audit(FodderReceptionInfo model) throws BOSException, EASBizException;
    public void unAudit(FodderReceptionInfo model) throws BOSException, EASBizException;
    public void viewStdUse(FodderReceptionInfo model) throws BOSException;
    public void chkVoucherFlag(FodderReceptionInfo model) throws BOSException;
    public void chkVoucherAll(FodderReceptionInfo model) throws BOSException;
    public void batchSubmit(FodderReceptionInfo model) throws BOSException;
    public void close(FodderReceptionInfo model) throws BOSException, EASBizException;
    public void unClose(FodderReceptionInfo model) throws BOSException, EASBizException;
}