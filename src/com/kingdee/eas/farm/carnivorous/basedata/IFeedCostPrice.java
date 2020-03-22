package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFeedCostPrice extends ICoreBillBase
{
    public FeedCostPriceCollection getFeedCostPriceCollection() throws BOSException;
    public FeedCostPriceCollection getFeedCostPriceCollection(EntityViewInfo view) throws BOSException;
    public FeedCostPriceCollection getFeedCostPriceCollection(String oql) throws BOSException;
    public FeedCostPriceInfo getFeedCostPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedCostPriceInfo getFeedCostPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedCostPriceInfo getFeedCostPriceInfo(String oql) throws BOSException, EASBizException;
    public void audit(FeedCostPriceInfo model) throws BOSException;
    public void unAudit(FeedCostPriceInfo model) throws BOSException;
}