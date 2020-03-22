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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IRewardAndPunishItem extends IDataBase
{
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RewardAndPunishItemInfo getRewardAndPunishItemInfo(String oql) throws BOSException, EASBizException;
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection() throws BOSException;
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection(EntityViewInfo view) throws BOSException;
    public RewardAndPunishItemCollection getRewardAndPunishItemCollection(String oql) throws BOSException;
    public void audit(RewardAndPunishItemInfo model) throws BOSException, EASBizException;
    public void unAudit(RewardAndPunishItemInfo model) throws BOSException, EASBizException;
}