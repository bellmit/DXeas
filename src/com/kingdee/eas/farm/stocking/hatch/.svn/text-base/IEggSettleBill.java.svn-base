package com.kingdee.eas.farm.stocking.hatch;

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

public interface IEggSettleBill extends ICoreBillBase
{
    public EggSettleBillCollection getEggSettleBillCollection() throws BOSException;
    public EggSettleBillCollection getEggSettleBillCollection(EntityViewInfo view) throws BOSException;
    public EggSettleBillCollection getEggSettleBillCollection(String oql) throws BOSException;
    public EggSettleBillInfo getEggSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggSettleBillInfo getEggSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggSettleBillInfo getEggSettleBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(EggSettleBillInfo model) throws BOSException;
    public void unAudit(EggSettleBillInfo model) throws BOSException;
    public void showPriceCol(EggSettleBillInfo model) throws BOSException;
    public void exeSettle(EggSettleBillInfo model) throws BOSException, EASBizException;
    public void batchSubmit(EggSettleBillInfo model) throws BOSException;
}