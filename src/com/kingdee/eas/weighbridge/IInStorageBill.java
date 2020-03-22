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

public interface IInStorageBill extends ICoreBillBase
{
    public InStorageBillCollection getInStorageBillCollection() throws BOSException;
    public InStorageBillCollection getInStorageBillCollection(EntityViewInfo view) throws BOSException;
    public InStorageBillCollection getInStorageBillCollection(String oql) throws BOSException;
    public InStorageBillInfo getInStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InStorageBillInfo getInStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InStorageBillInfo getInStorageBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(InStorageBillInfo model) throws BOSException;
    public void unAudit(InStorageBillInfo model) throws BOSException;
    public void updateSourceBill(InStorageBillInfo model) throws BOSException;
}