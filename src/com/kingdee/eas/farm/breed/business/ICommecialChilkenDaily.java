package com.kingdee.eas.farm.breed.business;

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

public interface ICommecialChilkenDaily extends ICoreBillBase
{
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection() throws BOSException;
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(EntityViewInfo view) throws BOSException;
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(String oql) throws BOSException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(CommecialChilkenDailyInfo model) throws BOSException;
    public void unAudit(CommecialChilkenDailyInfo model) throws BOSException;
    public List genNextBill(CommecialChilkenDailyInfo model) throws BOSException;
}