package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigDaily extends ICoreBillBase
{
    public CCPigDailyCollection getCCPigDailyCollection() throws BOSException;
    public CCPigDailyCollection getCCPigDailyCollection(EntityViewInfo view) throws BOSException;
    public CCPigDailyCollection getCCPigDailyCollection(String oql) throws BOSException;
    public CCPigDailyInfo getCCPigDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigDailyInfo getCCPigDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigDailyInfo getCCPigDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(CCPigDailyInfo model) throws BOSException;
    public void unAudit(CCPigDailyInfo model) throws BOSException;
}