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

public interface ITaraStorageBill extends ICoreBillBase
{
    public TaraStorageBillCollection getTaraStorageBillCollection() throws BOSException;
    public TaraStorageBillCollection getTaraStorageBillCollection(EntityViewInfo view) throws BOSException;
    public TaraStorageBillCollection getTaraStorageBillCollection(String oql) throws BOSException;
    public TaraStorageBillInfo getTaraStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TaraStorageBillInfo getTaraStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TaraStorageBillInfo getTaraStorageBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(TaraStorageBillInfo model) throws BOSException;
    public void unAudit(TaraStorageBillInfo model) throws BOSException;
    public void updateSourceBill(TaraStorageBillInfo model) throws BOSException;
}