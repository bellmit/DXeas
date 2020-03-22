package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IJournalTimesTree extends ITreeBase
{
    public JournalTimesTreeInfo getJournalTimesTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public JournalTimesTreeInfo getJournalTimesTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public JournalTimesTreeInfo getJournalTimesTreeInfo(String oql) throws BOSException, EASBizException;
    public JournalTimesTreeCollection getJournalTimesTreeCollection() throws BOSException;
    public JournalTimesTreeCollection getJournalTimesTreeCollection(EntityViewInfo view) throws BOSException;
    public JournalTimesTreeCollection getJournalTimesTreeCollection(String oql) throws BOSException;
}