package com.kingdee.eas.farm.feedfactory;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IJournalTimes extends IDataBase
{
    public JournalTimesInfo getJournalTimesInfo(IObjectPK pk) throws BOSException, EASBizException;
    public JournalTimesInfo getJournalTimesInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public JournalTimesInfo getJournalTimesInfo(String oql) throws BOSException, EASBizException;
    public JournalTimesCollection getJournalTimesCollection() throws BOSException;
    public JournalTimesCollection getJournalTimesCollection(EntityViewInfo view) throws BOSException;
    public JournalTimesCollection getJournalTimesCollection(String oql) throws BOSException;
}