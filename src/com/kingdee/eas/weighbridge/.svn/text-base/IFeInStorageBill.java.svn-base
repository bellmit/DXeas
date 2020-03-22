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

public interface IFeInStorageBill extends ICoreBillBase
{
    public FeInStorageBillCollection getFeInStorageBillCollection() throws BOSException;
    public FeInStorageBillCollection getFeInStorageBillCollection(EntityViewInfo view) throws BOSException;
    public FeInStorageBillCollection getFeInStorageBillCollection(String oql) throws BOSException;
    public FeInStorageBillInfo getFeInStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeInStorageBillInfo getFeInStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeInStorageBillInfo getFeInStorageBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FeInStorageBillInfo model) throws BOSException;
    public void unAudit(FeInStorageBillInfo model) throws BOSException;
}