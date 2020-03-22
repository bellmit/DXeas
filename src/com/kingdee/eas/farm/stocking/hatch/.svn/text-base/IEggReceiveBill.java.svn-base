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

public interface IEggReceiveBill extends ICoreBillBase
{
    public EggReceiveBillCollection getEggReceiveBillCollection() throws BOSException;
    public EggReceiveBillCollection getEggReceiveBillCollection(EntityViewInfo view) throws BOSException;
    public EggReceiveBillCollection getEggReceiveBillCollection(String oql) throws BOSException;
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggReceiveBillInfo getEggReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggReceiveBillInfo getEggReceiveBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(EggReceiveBillInfo model) throws BOSException;
    public void unAudit(EggReceiveBillInfo model) throws BOSException;
    public void showPriceCol(EggReceiveBillInfo model) throws BOSException;
    public void viewAllBill(EggReceiveBillInfo model) throws BOSException;
    public void deleteDownBill(EggReceiveBillInfo model) throws BOSException;
    public void toSettleBill(EggReceiveBillInfo model) throws BOSException;
    public void setColor(EggReceiveBillInfo model) throws BOSException;
}