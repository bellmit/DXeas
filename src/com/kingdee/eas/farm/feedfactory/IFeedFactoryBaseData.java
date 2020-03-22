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

public interface IFeedFactoryBaseData extends IDataBase
{
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(String oql) throws BOSException, EASBizException;
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection() throws BOSException;
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection(EntityViewInfo view) throws BOSException;
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection(String oql) throws BOSException;
}