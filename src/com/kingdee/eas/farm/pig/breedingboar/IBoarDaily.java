package com.kingdee.eas.farm.pig.breedingboar;

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

public interface IBoarDaily extends ICoreBillBase
{
    public BoarDailyCollection getBoarDailyCollection() throws BOSException;
    public BoarDailyCollection getBoarDailyCollection(EntityViewInfo view) throws BOSException;
    public BoarDailyCollection getBoarDailyCollection(String oql) throws BOSException;
    public BoarDailyInfo getBoarDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BoarDailyInfo getBoarDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BoarDailyInfo getBoarDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(BoarDailyInfo model) throws BOSException;
    public void unAudit(BoarDailyInfo model) throws BOSException;
}