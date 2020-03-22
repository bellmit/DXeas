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

public interface IFeedFactoryBaseDataTree extends ITreeBase
{
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(String oql) throws BOSException, EASBizException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection() throws BOSException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(EntityViewInfo view) throws BOSException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(String oql) throws BOSException;
}