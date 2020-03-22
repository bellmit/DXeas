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

public interface IOtherStorageBill extends ICoreBillBase
{
    public OtherStorageBillCollection getOtherStorageBillCollection() throws BOSException;
    public OtherStorageBillCollection getOtherStorageBillCollection(EntityViewInfo view) throws BOSException;
    public OtherStorageBillCollection getOtherStorageBillCollection(String oql) throws BOSException;
    public OtherStorageBillInfo getOtherStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OtherStorageBillInfo getOtherStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OtherStorageBillInfo getOtherStorageBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(OtherStorageBillInfo model) throws BOSException;
    public void unAudit(OtherStorageBillInfo model) throws BOSException;
    public void updateSourceBill(OtherStorageBillInfo model) throws BOSException;
}