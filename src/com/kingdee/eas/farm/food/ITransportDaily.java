package com.kingdee.eas.farm.food;

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

public interface ITransportDaily extends ICoreBillBase
{
    public TransportDailyCollection getTransportDailyCollection() throws BOSException;
    public TransportDailyCollection getTransportDailyCollection(EntityViewInfo view) throws BOSException;
    public TransportDailyCollection getTransportDailyCollection(String oql) throws BOSException;
    public TransportDailyInfo getTransportDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TransportDailyInfo getTransportDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TransportDailyInfo getTransportDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(TransportDailyInfo model) throws BOSException;
    public void unAudit(TransportDailyInfo model) throws BOSException;
}