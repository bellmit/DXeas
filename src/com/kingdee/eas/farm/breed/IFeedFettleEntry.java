package com.kingdee.eas.farm.breed;

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

public interface IFeedFettleEntry extends ICoreBillEntryBase
{
    public FeedFettleEntryInfo getFeedFettleEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFettleEntryInfo getFeedFettleEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFettleEntryInfo getFeedFettleEntryInfo(String oql) throws BOSException, EASBizException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection() throws BOSException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection(EntityViewInfo view) throws BOSException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection(String oql) throws BOSException;
}