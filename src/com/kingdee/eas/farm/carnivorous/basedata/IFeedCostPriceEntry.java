package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFeedCostPriceEntry extends ICoreBillEntryBase
{
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(String oql) throws BOSException, EASBizException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection() throws BOSException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(EntityViewInfo view) throws BOSException;
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(String oql) throws BOSException;
}