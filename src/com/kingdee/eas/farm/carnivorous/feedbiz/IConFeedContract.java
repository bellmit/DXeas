package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IConFeedContract extends ICoreBillBase
{
    public ConFeedContractCollection getConFeedContractCollection() throws BOSException;
    public ConFeedContractCollection getConFeedContractCollection(EntityViewInfo view) throws BOSException;
    public ConFeedContractCollection getConFeedContractCollection(String oql) throws BOSException;
    public ConFeedContractInfo getConFeedContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConFeedContractInfo getConFeedContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConFeedContractInfo getConFeedContractInfo(String oql) throws BOSException, EASBizException;
    public void audit(ConFeedContractInfo model) throws BOSException, EASBizException;
    public void unAudit(ConFeedContractInfo model) throws BOSException, EASBizException;
    public void updateFeed(ConFeedContractInfo model) throws BOSException, EASBizException;
}