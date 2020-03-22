package com.kingdee.eas.farm.breed;

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

public interface IFeedFettle extends ICoreBillBase
{
    public FeedFettleCollection getFeedFettleCollection() throws BOSException;
    public FeedFettleCollection getFeedFettleCollection(EntityViewInfo view) throws BOSException;
    public FeedFettleCollection getFeedFettleCollection(String oql) throws BOSException;
    public FeedFettleInfo getFeedFettleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFettleInfo getFeedFettleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFettleInfo getFeedFettleInfo(String oql) throws BOSException, EASBizException;
}