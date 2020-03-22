package com.kingdee.eas.farm.feemanager.basedata;

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

public interface ISettlement extends IDataBase
{
    public SettlementInfo getSettlementInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettlementInfo getSettlementInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettlementInfo getSettlementInfo(String oql) throws BOSException, EASBizException;
    public SettlementCollection getSettlementCollection() throws BOSException;
    public SettlementCollection getSettlementCollection(EntityViewInfo view) throws BOSException;
    public SettlementCollection getSettlementCollection(String oql) throws BOSException;
    public void review(SettlementInfo model) throws BOSException;
    public void unreview(SettlementInfo model) throws BOSException;
}