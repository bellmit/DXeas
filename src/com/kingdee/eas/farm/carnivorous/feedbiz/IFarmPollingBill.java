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

public interface IFarmPollingBill extends ICoreBillBase
{
    public FarmPollingBillCollection getFarmPollingBillCollection() throws BOSException;
    public FarmPollingBillCollection getFarmPollingBillCollection(EntityViewInfo view) throws BOSException;
    public FarmPollingBillCollection getFarmPollingBillCollection(String oql) throws BOSException;
    public FarmPollingBillInfo getFarmPollingBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmPollingBillInfo getFarmPollingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmPollingBillInfo getFarmPollingBillInfo(String oql) throws BOSException, EASBizException;
    public void displayPic(FarmPollingBillInfo model) throws BOSException;
    public void audit(FarmPollingBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmPollingBillInfo model) throws BOSException, EASBizException;
}