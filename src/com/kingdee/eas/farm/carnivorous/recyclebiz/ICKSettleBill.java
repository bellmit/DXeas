package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
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

public interface ICKSettleBill extends ICoreBillBase
{
    public CKSettleBillCollection getCKSettleBillCollection() throws BOSException;
    public CKSettleBillCollection getCKSettleBillCollection(EntityViewInfo view) throws BOSException;
    public CKSettleBillCollection getCKSettleBillCollection(String oql) throws BOSException;
    public CKSettleBillInfo getCKSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKSettleBillInfo getCKSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKSettleBillInfo getCKSettleBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CKSettleBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CKSettleBillInfo model) throws BOSException, EASBizException;
    public void close(CKSettleBillInfo model) throws BOSException, EASBizException;
    public void unClose(CKSettleBillInfo model) throws BOSException, EASBizException;
    public Map execSettle(CKSettleBillInfo model) throws BOSException, EASBizException;
    public void updateSaleData(CKSettleBillInfo model) throws BOSException, EASBizException;
    public Map updateActAmt(CKSettleBillInfo model) throws BOSException, EASBizException;
    public void updateSale(CKSettleBillInfo model) throws BOSException;
    public void hasPay(CKSettleBillInfo model) throws BOSException, EASBizException;
}