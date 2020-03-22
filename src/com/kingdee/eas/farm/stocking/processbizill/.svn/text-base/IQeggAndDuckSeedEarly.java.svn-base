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

public interface IQeggAndDuckSeedEarly extends ICoreBillBase
{
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection() throws BOSException;
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection(EntityViewInfo view) throws BOSException;
    public QeggAndDuckSeedEarlyCollection getQeggAndDuckSeedEarlyCollection(String oql) throws BOSException;
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QeggAndDuckSeedEarlyInfo getQeggAndDuckSeedEarlyInfo(String oql) throws BOSException, EASBizException;
    public void audit(QeggAndDuckSeedEarlyInfo model) throws BOSException;
    public void unAudit(QeggAndDuckSeedEarlyInfo model) throws BOSException;
}