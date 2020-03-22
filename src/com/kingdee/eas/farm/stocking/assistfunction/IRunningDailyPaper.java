package com.kingdee.eas.farm.stocking.assistfunction;

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

public interface IRunningDailyPaper extends ICoreBillBase
{
    public RunningDailyPaperCollection getRunningDailyPaperCollection() throws BOSException;
    public RunningDailyPaperCollection getRunningDailyPaperCollection(EntityViewInfo view) throws BOSException;
    public RunningDailyPaperCollection getRunningDailyPaperCollection(String oql) throws BOSException;
    public RunningDailyPaperInfo getRunningDailyPaperInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RunningDailyPaperInfo getRunningDailyPaperInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RunningDailyPaperInfo getRunningDailyPaperInfo(String oql) throws BOSException, EASBizException;
}