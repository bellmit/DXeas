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

public interface IOutStorageBill extends ICoreBillBase
{
    public OutStorageBillCollection getOutStorageBillCollection() throws BOSException;
    public OutStorageBillCollection getOutStorageBillCollection(EntityViewInfo view) throws BOSException;
    public OutStorageBillCollection getOutStorageBillCollection(String oql) throws BOSException;
    public OutStorageBillInfo getOutStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OutStorageBillInfo getOutStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OutStorageBillInfo getOutStorageBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(OutStorageBillInfo model) throws BOSException;
    public void unAudit(OutStorageBillInfo model) throws BOSException;
}