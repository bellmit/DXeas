package com.kingdee.eas.farm.feemanager.basedata;

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

public interface ISettlementTree extends ITreeBase
{
    public SettlementTreeInfo getSettlementTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettlementTreeInfo getSettlementTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettlementTreeInfo getSettlementTreeInfo(String oql) throws BOSException, EASBizException;
    public SettlementTreeCollection getSettlementTreeCollection() throws BOSException;
    public SettlementTreeCollection getSettlementTreeCollection(EntityViewInfo view) throws BOSException;
    public SettlementTreeCollection getSettlementTreeCollection(String oql) throws BOSException;
}