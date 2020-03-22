package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IRunningDailyPaperEntry extends ICoreBillEntryBase
{
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RunningDailyPaperEntryInfo getRunningDailyPaperEntryInfo(String oql) throws BOSException, EASBizException;
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection() throws BOSException;
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection(EntityViewInfo view) throws BOSException;
    public RunningDailyPaperEntryCollection getRunningDailyPaperEntryCollection(String oql) throws BOSException;
}