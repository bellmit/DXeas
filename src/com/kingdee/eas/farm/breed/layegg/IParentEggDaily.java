package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IParentEggDaily extends ICoreBillBase
{
    public ParentEggDailyCollection getParentEggDailyCollection() throws BOSException;
    public ParentEggDailyCollection getParentEggDailyCollection(EntityViewInfo view) throws BOSException;
    public ParentEggDailyCollection getParentEggDailyCollection(String oql) throws BOSException;
    public ParentEggDailyInfo getParentEggDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ParentEggDailyInfo getParentEggDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ParentEggDailyInfo getParentEggDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(ParentEggDailyInfo model) throws BOSException;
    public void unAudit(ParentEggDailyInfo model) throws BOSException;
    public List genNextBill(ParentEggDailyInfo model) throws BOSException;
    public void reShareInfos(ParentEggDailyInfo model) throws BOSException;
    public void refreshInventory(ParentEggDailyInfo model) throws BOSException;
}