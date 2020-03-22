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

public interface IAppealBill extends ICoreBillBase
{
    public AppealBillCollection getAppealBillCollection() throws BOSException;
    public AppealBillCollection getAppealBillCollection(EntityViewInfo view) throws BOSException;
    public AppealBillCollection getAppealBillCollection(String oql) throws BOSException;
    public AppealBillInfo getAppealBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AppealBillInfo getAppealBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AppealBillInfo getAppealBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(AppealBillInfo model) throws BOSException;
    public void unAudit(AppealBillInfo model) throws BOSException;
}