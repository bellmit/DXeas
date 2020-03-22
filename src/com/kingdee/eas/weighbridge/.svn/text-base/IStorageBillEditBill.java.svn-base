package com.kingdee.eas.weighbridge;

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

public interface IStorageBillEditBill extends ICoreBillBase
{
    public StorageBillEditBillCollection getStorageBillEditBillCollection() throws BOSException;
    public StorageBillEditBillCollection getStorageBillEditBillCollection(EntityViewInfo view) throws BOSException;
    public StorageBillEditBillCollection getStorageBillEditBillCollection(String oql) throws BOSException;
    public StorageBillEditBillInfo getStorageBillEditBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StorageBillEditBillInfo getStorageBillEditBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StorageBillEditBillInfo getStorageBillEditBillInfo(String oql) throws BOSException, EASBizException;
}