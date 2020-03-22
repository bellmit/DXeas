package com.kingdee.eas.farm.stocking.basedata;

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

public interface ISettlementItem extends IDataBase
{
    public SettlementItemInfo getSettlementItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettlementItemInfo getSettlementItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettlementItemInfo getSettlementItemInfo(String oql) throws BOSException, EASBizException;
    public SettlementItemCollection getSettlementItemCollection() throws BOSException;
    public SettlementItemCollection getSettlementItemCollection(EntityViewInfo view) throws BOSException;
    public SettlementItemCollection getSettlementItemCollection(String oql) throws BOSException;
    public void audit(SettlementItemInfo model) throws BOSException, EASBizException;
    public void unAudit(SettlementItemInfo model) throws BOSException, EASBizException;
}