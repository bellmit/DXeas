package com.kingdee.eas.custom.tocloud;

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

public interface ISynDateLogEntry extends ICoreBillEntryBase
{
    public SynDateLogEntryInfo getSynDateLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SynDateLogEntryInfo getSynDateLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SynDateLogEntryInfo getSynDateLogEntryInfo(String oql) throws BOSException, EASBizException;
    public SynDateLogEntryCollection getSynDateLogEntryCollection() throws BOSException;
    public SynDateLogEntryCollection getSynDateLogEntryCollection(EntityViewInfo view) throws BOSException;
    public SynDateLogEntryCollection getSynDateLogEntryCollection(String oql) throws BOSException;
}