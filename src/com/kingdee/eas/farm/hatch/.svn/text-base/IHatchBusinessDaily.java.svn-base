package com.kingdee.eas.farm.hatch;

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

public interface IHatchBusinessDaily extends ICoreBillBase
{
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection() throws BOSException;
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection(EntityViewInfo view) throws BOSException;
    public HatchBusinessDailyCollection getHatchBusinessDailyCollection(String oql) throws BOSException;
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBusinessDailyInfo getHatchBusinessDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchBusinessDailyInfo model) throws BOSException;
    public void unAudit(HatchBusinessDailyInfo model) throws BOSException;
}