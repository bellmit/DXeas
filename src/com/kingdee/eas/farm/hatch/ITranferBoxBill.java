package com.kingdee.eas.farm.hatch;

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

public interface ITranferBoxBill extends ICoreBillBase
{
    public TranferBoxBillCollection getTranferBoxBillCollection() throws BOSException;
    public TranferBoxBillCollection getTranferBoxBillCollection(EntityViewInfo view) throws BOSException;
    public TranferBoxBillCollection getTranferBoxBillCollection(String oql) throws BOSException;
    public TranferBoxBillInfo getTranferBoxBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TranferBoxBillInfo getTranferBoxBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TranferBoxBillInfo getTranferBoxBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(TranferBoxBillInfo model) throws BOSException;
    public void unAudit(TranferBoxBillInfo model) throws BOSException;
}